package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.Entity.ProjectOwner;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectOwnerRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ProjectService;



@Controller
@RequestMapping("/create_project")

public class StartProjectController {

    @Autowired
    private ProjectOwnerRepository projectOwnerRepository;

        @Autowired
    private ProjectService projectService;
    @Autowired
    UserRepository userRepository;

    public StartProjectController(ProjectOwnerRepository projectOwnerRepository) {
        this.projectOwnerRepository = projectOwnerRepository;
    }

    // Handles GET request for starting a new project
    @GetMapping
    public String startProject(Model model) {
        model.addAttribute("project", new ProjectOwner()); // Initialize a new ProjectOwner
        return "create_project"; // Return the name of the Thymeleaf template (start_project.html)
    }

    // Handles POST request for creating the project
    @PostMapping
    public String createProject(@ModelAttribute("project") ProjectOwner project,RedirectAttributes redirectAttributes,String email) {
        User user = userRepository.findByEmail(email);
        project.setOwner(user);
        projectOwnerRepository.save(project);
        redirectAttributes.addFlashAttribute("message", "Project created successfully!"); // Save the project to the database
        return "redirect:/details/" + project.getId(); // Redirect to project details page
    }


    @Controller
public class ProjectController {

    @GetMapping("/details/{id}")
    public String getProjectDetails(@PathVariable Integer id, Model model) {
        // Fetch project details using the ID
        ProjectOwner project = projectService.findById(id);
        model.addAttribute("project", project);
        return "details";  // Corresponding view name (Thymeleaf template)
    }
}

    
}
