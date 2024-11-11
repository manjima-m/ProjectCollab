package com.example.demo.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectOwner;
import com.example.demo.Entity.User;


@Repository
public interface ProjectOwnerRepository extends JpaRepository<ProjectOwner, Integer> {

    ProjectOwner save(Project project);

    Optional<ProjectOwner> findById(Integer projectId);

   // Optional<User> findByEmail(String email);

   

    
  

   
}
