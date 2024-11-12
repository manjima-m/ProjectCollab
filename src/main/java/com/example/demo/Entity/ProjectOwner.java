package com.example.demo.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "project_owner")
public class ProjectOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId; // Maps to project_id in the database

    @Column(name = "project_name", nullable = false)
    private String projectName; // Maps to project_name in the database

    @Column(nullable = false)
    private int duration; // Maps to duration in the database

    @Column(name = "collaborator_requirements", nullable = false)
    private boolean collaboratorRequirements; // Maps to collaborator_requirements in the database

    @Column(name = "skills_required")
    private String skillsRequired; // Maps to skills_required in the database

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExperienceLevel experience; // Maps to experience in the database

    
  /*  @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    private User owner; // Maps to owner_id in the database, referencing User's 'id'
*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User owner; // Maps to owner_id in the database, referencing User's 'id'
   

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCollaboratorRequirements() {
        return collaboratorRequirements;
    }

    public void setCollaboratorRequirements(boolean collaboratorRequirements) {
        this.collaboratorRequirements = collaboratorRequirements;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public ExperienceLevel getExperience() {
        return experience;
    }

    public void setExperience(ExperienceLevel experience) {
        this.experience = experience;
    }

     public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner=owner;
    }

    public int getId() {
        return projectId; // Added method for compatibility
    }

    

    


    // Enum for Experience Levels
    public enum ExperienceLevel {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }

    

}

  
    
    

    


