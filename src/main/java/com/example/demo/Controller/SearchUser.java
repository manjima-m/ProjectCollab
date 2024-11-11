package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.User;

import com.example.demo.Repository.UserRepository;

@Controller
public class SearchUser {
    

    @Autowired
    UserRepository userRepository;

   

     @GetMapping("/search_users")
    public String searchUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "search_users"; // Points to search_projects.html
    }


    @GetMapping("/user/details/{email}")
public String viewUserProfile(@PathVariable("email") String email, Model model) {
    User user = userRepository.findByEmail(email);
    model.addAttribute("user", user);
    return "user_details"; // Thymeleaf template for full user profile
}

}
