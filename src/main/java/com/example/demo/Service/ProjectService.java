package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.ProjectOwner;

import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectOwnerRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectOwnerRepository projectOwnerRepository;
    @Autowired
    private UserRepository userRepository;

    public ProjectOwner saveProject(ProjectOwner project) {
        return projectOwnerRepository.save(project);
    }

    public ProjectOwner findById(Integer id) {
        return projectOwnerRepository.findById(id).orElse(null);
    }

    

  
 

    public User findProjectOwnerByEmail(String email) {
        return userRepository.findByEmail(email);
   



}

}