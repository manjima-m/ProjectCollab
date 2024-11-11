package com.example.demo.Entity;

import java.math.BigDecimal;


import jakarta.persistence.*;

@Entity
@Table(name = "eductaion")

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;

private String InstitutionName;
private int graduationYear;
@Column(precision = 5, scale = 2)
private BigDecimal marks;

public enum education_level{
    highschool,
    highersecondary,
    graduate,
    postgraduate,
    certification

}
    

    @ManyToOne
    @JoinColumn(name = "email",referencedColumnName = "email")
    private User user;

    // Getters and Setters

    public int getId() {
        return eid;
    }

    @Enumerated(EnumType.STRING) // Use EnumType.ORDINAL for ordinal values
    private education_level educationLevel;
    
   
    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionNName(String InstitutionName) {
        this.InstitutionName=InstitutionName;
    }
    public int getgraduationYear() {
        return graduationYear;
    }

    public void setgraduationYear(int graduationYear) {
        this.graduationYear=graduationYear;
    }

    public BigDecimal getmarks() {
        return marks;
    }

    public void setmarks(BigDecimal marks) {
        this.marks=marks;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public education_level geteducationaLevel(){
        return educationLevel;
    }

    public void seteducationlevel(education_level educationLevel){
        this.educationLevel=educationLevel;
    }

    
}

