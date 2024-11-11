
package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectOwner;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    void save(ProjectOwner project);

    Optional<ProjectOwner> findById(Integer projectId);
}
