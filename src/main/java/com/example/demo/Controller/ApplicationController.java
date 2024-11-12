package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.ProjectOwner;
import com.example.demo.Entity.User;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.ProjectService;

@Controller
public class ApplicationController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmailService emailService;

    // Handle the form submission for the application
   /*  @PostMapping("/projects/sendApplication")
    public String sendApplication(@RequestParam Integer projectId, @RequestParam String applicationLetter, Model model) {
        // Get the project owner details
        ProjectOwner project = projectService.findById(projectId);
        User projectOwner = project.getOwner(); // assuming 'getOwnerId()' retrieves the project owner
        
        // Send an email to the project owner
        emailService.sendEmail(projectOwner.getEmail(), "New Application for Your Project", applicationLetter);
        
        // Optional: add success message or redirect to another page
        model.addAttribute("message", "Application submitted successfully");
        return "application_confirmation"; // View name or redirect
    }
*/
    @PostMapping("/projects/sendApplication")
    public String showPage(Model model) {
        model.addAttribute("error","");
        return "page";
    }
}

