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
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/create_project")

public class StartProjectController {

    @Autowired
    private ProjectOwnerRepository projectOwnerRepository;

        @Autowired
    private ProjectService projectService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public StartProjectController(ProjectOwnerRepository projectOwnerRepository) {
        this.projectOwnerRepository = projectOwnerRepository;
    }

    // Handles GET request for starting a new project
    @GetMapping
    public String startProject(Model model,HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
    if (loggedInUser != null) {
        model.addAttribute("email", loggedInUser.getEmail());
        model.addAttribute("name", loggedInUser.getName());
    } 
    /*User user = (User) session.getAttribute("user");
    if (user != null) {
        model.addAttribute("user", user);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("name", user.getName());
        System.out.println("User on home page: " + user.getEmail());
        ProjectOwner projects = new ProjectOwner();
        String email=projects.getEmail();
        projects.setEmail(email);
    }*/
        model.addAttribute("project", new ProjectOwner()); 
         // Initialize a new ProjectOwner
        return "create_project"; // Return the name of the Thymeleaf template (start_project.html)
    }

    // Handles POST request for creating the project
    @PostMapping
    public String createProject(@ModelAttribute("project") ProjectOwner project,RedirectAttributes redirectAttributes,String email) {
        System.out.println(project);
        System.out.println(redirectAttributes);
        System.out.println(email);
        User user = userRepository.findByEmail(email);
        project.setOwner(user);
        projectOwnerRepository.save(project);
        redirectAttributes.addFlashAttribute("message", "Project created successfully!"); // Save the project to the database
        return "redirect:/details/" + project.getProjectId(); // Redirect to project details page
    }


    @Controller
public class ProjectController {

    @GetMapping("/details/{id}")
    public String getProjectDetails(@PathVariable Integer id, Model model,HttpSession session) {
        // Fetch project details using the ID
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("email", loggedInUser.getEmail());
            model.addAttribute("name", loggedInUser.getName());
        }
        ProjectOwner project = projectService.findById(id);
        model.addAttribute("project", project);
       
        return "details";  // Corresponding view name (Thymeleaf template)
    }
}

    
}
