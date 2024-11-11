package com.example.demo.Entity;

import jakarta.persistence.*;

//import java.sql.Blob;
import java.util.List;



@Entity
@Table(name="user")
public class User {
    @Id
    @Column(nullable = false, unique = true)
    private String email;

    private String name;
    private int age;
    private String gender;
    private String phone;
    
   

   
  
    private String password;
    
   /*  @ManyToOne
    @JoinColumn(name = "projectId") // Ensure this column name exists in your database or adjust accordingly
    private ProjectOwner project;*/
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
private List<ProjectOwner> projects;


    @Column(name = "profile_picture")
    @Lob
    private  byte[] profilePicture;

    @Column(name = "bio")
    private String bio;

    @Column(columnDefinition="TEXT")
private String description;

    
     
    /*@Enumerated(EnumType.STRING)
    private Role role;*/
    private String role;
   

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Education> educationDetails;

    // Getters and Setters

   

    // Other fields...

    // Getters and setters
    
    public enum Role {
        PROJECT_OWNER,
        COLLABORATOR;
    }

    

    


   /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Role getRole() {
        return role;
    }

    // Setter for 'role'
    public void setRole(Role role) {
        this.role = role;
    }*/

    public void setRole(String role){
        this.role=role;
    }

    public String getRole(){
        return role;
    }

    
    
    

    public List<Education> getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(List<Education> educationDetails) {
        this.educationDetails = educationDetails;
    }

   public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePictureBytes) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
