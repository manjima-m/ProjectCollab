package com.example.demo.Service;


import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
   /*  public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }*/


    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
   public User getLoggedInUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }


  /*   public void setupProfile(int id,  String bio, String description) throws IOException {
        User user = getUserById(id);
        if (user == null) return;

        // Save profile picture
        /*if (!file.isEmpty()) {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = id + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, file.getBytes());
            user.setProfilePicture("/" + UPLOAD_DIR + fileName);
        }
         // Save profile picture directly to the database as byte[]
        
           // byte[] profilePictureBytes = file.getBytes();
           // user.setProfilePicture(profilePictureBytes); // Store the file's byte array directly
        
        // Optionally handle the case where no file is uploaded
        
    


        // Set bio, description, and created year
        user.setBio(bio);
        user.setDescription(description);


        userRepository.save(user);
    }*/

   

}

