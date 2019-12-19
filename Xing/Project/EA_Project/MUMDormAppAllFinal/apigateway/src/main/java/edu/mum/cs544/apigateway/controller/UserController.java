package edu.mum.cs544.apigateway.controller;

import edu.mum.cs544.apigateway.domain.Role;
import edu.mum.cs544.apigateway.domain.User;
import edu.mum.cs544.apigateway.service.CartService;
import edu.mum.cs544.apigateway.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes({"username","userId","role","itemSize","carts"})
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private CartService cartService;

    @GetMapping(value = "/")
    public String userHome(){
        return "home";
    }

//    @GetMapping(value = "/logout")
//    public String logout(SessionStatus status){
//        status.setComplete();
//        return "redirect:/users/";
//    }

    @Secured("Admin")
    @GetMapping(value = "/all")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAll());
        return "usersList";
    }

    @Secured("Admin")
    @GetMapping("/search/{id}")
    public String getUser(@PathVariable long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "userDetail";
    }

    @GetMapping("/signup")
    public String signupform(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/create")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model, RedirectAttributes msg){
        System.out.println(user);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "signup";
        }
        String userInputEmail=user.getEmail();
        User dbUser=userService.getUserByEmail(userInputEmail);
        if(dbUser==null) {
            userService.addUser(user);
            return "redirect:/users/";
        }
        else {
            msg.addFlashAttribute("msg","Email already registered, try another email address");
            return "redirect:/users/signup";
        }
    }

    @GetMapping("/modify/{id}")
    public String updateUser(@PathVariable long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "changeDetail";
    }
    @PostMapping("/modify")
    public String saveUpdate(@ModelAttribute User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "redirct:/modify";
        }
        userService.update(user);
        return "redirect:/users/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "redirect:/users/all";
    }

    @GetMapping("/signin")
    public String newLogIn(){
        return "signin";
    }

    @PostMapping("/login")
    public String checkLogIn(String email, String password, Model model, RedirectAttributes redirectAttributes){
//        System.out.println("printing user input");
//        System.out.println(email+"\n"+password);
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        try {
            User result=userService.getUserByObject(user);
//        System.out.println("result from query" +result);

            if (result != null) {
                model.addAttribute("userId", result.getUid());
                model.addAttribute("username", result.getUserName());
                cartService.addCartInfo(result.getUid(), model);
                for(Role r:result.getRoles()){
                    if(r.getRole().equals("ADMIN"))
                        model.addAttribute("role", r.getRole());
                }
                return "redirect:/users/";
            } else {
                redirectAttributes.addFlashAttribute("message", "Email/Password not matched");
                return "redirect:/users/signin";
            }
        }catch (Exception e){
            System.out.println("Exception occured in controller: userService.getUserByObject(user)"+new Date());
            return "redirect:/users/signin";
        }

    }

    @GetMapping("/logout")
    public String signOut(SessionStatus status){
        status.setComplete();
        System.out.println("===================Inside Logout====================");
        return "redirect:/";
    }
}