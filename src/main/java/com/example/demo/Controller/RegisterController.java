package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegisterController {
   

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    
@GetMapping("/register")
    public String register(Model model) {
        List<String> roles = Arrays.asList("Project Owner", "Collaborator");
        
        // Add the roles to the model
        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "register"; // Returns the registration page
    }

    @PostMapping("/register")
    public String register( User user,
    Model model) {
        // Perform any necessary validation here (e.g., check for existing email)
        userService.registerUser(user);
        return "/login"; 
        
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        try {
            // Retrieve the user entity
            User user = userRepository.findByEmail(email);
            
            // Set the profile picture as byte array
            user.setProfilePicture(file.getBytes());
            userRepository.save(user);
    
            return "Profile picture uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed: " + e.getMessage();
        }
    }
    
    /*@GetMapping("/setupProfile")
    public String setupProfilePage(HttpSession session, Model model) {
       Integer id = (Integer) session.getAttribute("id");
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "setupProfile";
    }

    // Handle profile setup form submission
  /*   @PostMapping("/setupProfile")
    public String setupProfile(HttpSession session, Model model){
        Integer id = (Integer) session.getAttribute("id");
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
       // @ModelAttribute User user,
           // @RequestParam("profilePicture") MultipartFile file,
            
          //  HttpSession session) throws IOException {

                //User loggedInUser = (User) session.getAttribute("loggedInUser"); // Retrieve the logged-in user from session
               /*  if (loggedInUser != null) {
                    // Convert MultipartFile to byte array
                    if(!file.isEmpty()){
                   loggedInUser.setProfilePicture(file.getBytes());
                    }
            
// Set the values to the user object

//loggedInUser.setBio(user.getBio());
//loggedInUser.setDescription(user.getDescription());

       //int u_id = (Integer) session.getAttribute("id");
       // userService.setupProfile(user.getId(),  user.getBio(), user.getDescription());
                
        return "redirect:/login";

        @PostMapping("/setupProfile")
        public String setupProfile() {
            
                // Perform any necessary validation here (e.g., check for existing email)
                userService.setupProfile(user);
                return "redirect:/login";

        }*/
    
}


