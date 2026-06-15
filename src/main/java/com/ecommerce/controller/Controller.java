package com.ecommerce.controller;

import com.ecommerce.CustomUserDetails;
import com.ecommerce.dto.LoginForm;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.RegisterForm;
import com.ecommerce.services.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final ProductService productService;

    public Controller(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("user", user);
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
    @GetMapping("/admin/products")
    public String admin(Model model) {
        model.addAttribute("products", null);
        return "admin-products";
    }
    @GetMapping("/admin/dashboard")
    public String admindashboard(Model model) {
        model.addAttribute("products", null);
        return "admin-dashboard";
    }
    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("products", null);
        return "account";
    }
    @GetMapping("/admin/products/new")
    public String productForm(Model model) {
        model.addAttribute("product", new ProductDto());
        return "productform";
    }
    @PostMapping("/admin/products")
    public String save(@ModelAttribute ProductDto dto) {
        productService.addProduct(dto);
        return "redirect:/admin/dashboard";
    }
}
