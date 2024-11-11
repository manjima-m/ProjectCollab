package com.example.demo.Controller;



import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;


import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    

    @PostMapping("/login")
    public String login(String email, String password, Model model,HttpSession session) {
        // Validate user credentials
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // Store user in session
            session.setAttribute("user", user);
            session.setAttribute("currentUserEmail", user.getEmail());
            // Logging for debugging
        System.out.println("User logged in: " + user.getEmail());
            // Redirect based on user role
            if (user.getRole().equals("COLLABORATOR")) {
                
                return "redirect:/home_collaborator"; // Collaborator home page
            } else if (user.getRole().equals("PROJECT_OWNER")) {
                return "redirect:/home_owner"; // Project owner home page
            }
        }
        // Add error message if login fails
        model.addAttribute("error", "Invalid email or password");
        return "login"; // Return to login page
    }

    @GetMapping("/login")
    public String showloginPage(Model model) {
        model.addAttribute("error","");
        return "login";
    }

    @GetMapping("/home_collaborator")
public String collaboratorHome(HttpSession session, Model model) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
        model.addAttribute("user", user);
        return "home_collaborator";  // Make sure this matches your HTML file name
    }
    return "redirect:/login";  // Redirect if user is not found
}

@GetMapping("/home_owner")
public String OwnerHome(HttpSession session, Model model) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
        model.addAttribute("user", user);
        return "home_owner";  // Make sure this matches your HTML file name
    }
    return "redirect:/login";  // Redirect if user is not found
}


   /*  @GetMapping("/home_collaborator")
    public String collaboratorHome(HttpSession session, Model model,String email) {
    // Retrieve the user ID from the session
    email = (String) session.getAttribute("email");
    
    
    if (email != null) {
        // Fetch user details using findById
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "home_collaborator"; 
    } /*else {
        // Handle the case where the user ID is not found (e.g., redirect to login)
        return "redirect:/login";
    }
    return "redirect:/login";
    // Ensure this is the correct view name
}*/


}
