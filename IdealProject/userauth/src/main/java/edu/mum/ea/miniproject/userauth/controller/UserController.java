package edu.mum.ea.miniproject.userauth.controller;
import edu.mum.ea.miniproject.userauth.domain.User;
import edu.mum.ea.miniproject.userauth.payload.LoginRequest;
import edu.mum.ea.miniproject.userauth.security.model.AuthenticationResponse;
import edu.mum.ea.miniproject.userauth.security.model.UserPrincipal;
import edu.mum.ea.miniproject.userauth.service.JwtTokenProvider;
import edu.mum.ea.miniproject.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;
    @GetMapping("/user/login")
    public String loginPage(@ModelAttribute LoginRequest loginRequest){
        return "login";
    }

    @PostMapping("/user/login")
    public  ModelAndView login(@Valid LoginRequest loginRequest){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken( authentication);
        modelAndView.addObject("response",ResponseEntity.ok(new AuthenticationResponse(jwt)));
        System.out.println("jwt token" + ResponseEntity.ok(new AuthenticationResponse(jwt)));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/user/register", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> userExists = userService.findByEmail(user.getEmail());
        if(userExists.isPresent()){
            System.out.println("User exists");
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            System.out.println("registration form has errors !!!!!!!!!!!!!");
            modelAndView.setViewName("registration");
        }
        else {

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
            System.out.println("user :"+user +" registered !!!!!");
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.addObject("loginRequest", new LoginRequest());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }
}
