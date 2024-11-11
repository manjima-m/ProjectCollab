package com.example.demo.Controller;




import com.example.demo.Entity.ProjectOwner;
import com.example.demo.Entity.User;

import com.example.demo.Service.ProjectService;
import com.example.demo.Service.UserService;

import java.time.LocalDateTime;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class ProjectRequestController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    
    
    @GetMapping("/projects/request")
    public String showApplicationForm( Integer projectId, Model model) {
        // Retrieve project and owner details using the projectId
        ProjectOwner project = projectService.findById(projectId); // Assuming this method exists in projectService
        User projectOwner = project.getOwner(); // Get the project owner associated with this project

        // Add project and owner details to the model to display on the application form
        model.addAttribute("project", project);
        model.addAttribute("projectOwner", projectOwner);

        // Return the application form view
        return "applicationForm";
    }

    @GetMapping("/applicationForm/{projectId}")
    public String ApplicationForm( Integer projectId, Model model) {
        ProjectOwner project = projectService.findById(projectId);

        // Check and explicitly load the project owner if lazy loading is in place
        if (project.getOwner() != null) {
            User projectOwner = project.getOwner();
            model.addAttribute("projectOwner", projectOwner);
        } else {
            // Handle potential null case here if necessary
            return "redirect:/projects";
        }

        model.addAttribute("project", project);
        return "applicationForm";
    }


  

   


    
}




