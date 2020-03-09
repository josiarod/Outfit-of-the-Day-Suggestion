package com.example.outfitproject.model.controllers;

import com.cloudinary.utils.ObjectUtils;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.UserRepository;
import com.example.outfitproject.main.services.UserService;
import com.example.outfitproject.model.config.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @GetMapping("/add")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "form";
//    }

//    @RequestMapping("/secure")
//
//    public String secure(Principal principal, Model model){
//        String username = principal.getName();
//        model.addAttribute("user", userRepository.findByUsername(username));
//        return "secure";
//    }
    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "register";
        }else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account created");
        }
        return  "redirect:/login";
    }

}


