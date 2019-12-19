package cs544.controller;

import cs544.domain.Authority;
import cs544.domain.User;
import cs544.service.AuthorityService;
import cs544.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private AuthorityService authorityService;
    ;

    public UserController(UserService userService, AuthorityService authorityService) {
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @ModelAttribute("authorities")
    public List<Authority> getAuthories() {
        return authorityService.getAuthorities();
    }

    @GetMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            userService.save(user);
//            model.addAttribute("successMessage", "User has been registered successfully");
//            model.addAttribute("user", new User());
            return "redirect:/login";
        }
    }



}
