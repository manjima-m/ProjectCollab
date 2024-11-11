package com.example.demo.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.ProjectOwner;


import com.example.demo.Repository.ProjectOwnerRepository;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ProjectService;
import com.example.demo.Service.UserService;

@Controller

public class SearchProject {
    @Autowired
    private ProjectOwnerRepository projectOwnerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ProjectService projectService; // Assume you have a service to handle the business logic

    @Autowired
    private UserService userService;

    @GetMapping("/search_projects")
    public String searchProjects(Model model) {
        List<ProjectOwner> projects = projectOwnerRepository.findAll();
        model.addAttribute("projects", projects);
        return "search_projects"; // Points to search_projects.html
    }


/*  @PostMapping("search_projects/request")
    public ResponseEntity<?> sendRequest(@RequestBody ProjectRequest request, @RequestParam String email) {
       User projectOwner = projectService.findProjectOwnerByEmail(email);
        if (projectOwner != null) {
            request.setProjectOwner(projectOwner);
            // Save ProjectRequest and initiate chat with project owner
            return ResponseEntity.ok().body("Redirecting to chat with " + projectOwner.getEmail());
        } else {
            return ResponseEntity.status(404).body("Project Owner not found");
        }
    }*/


}