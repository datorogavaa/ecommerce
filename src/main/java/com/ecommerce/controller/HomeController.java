package com.ecommerce.controller;

import com.ecommerce.dto.LoginForm;
import com.ecommerce.dto.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm()); // ← Add this
        return "register";
    }
    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cartItems", null); // ← Add this
        return "cart";
    }
}
