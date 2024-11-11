package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false)
    private String pname;

     @ManyToOne
    @JoinColumn(name = "email", nullable = false) // owner_id will be the foreign key column
    private User user;


    public Project() {}

    public Project(String pname, User user) {
        this.pname = pname;
        this.user=user;
    }

    // Getters and Setters
    public Long getId() { return pid; }
    public void setId(Long pid) { this.pid = pid; }

    public String getName() { return pname; }
    public void setName(String pname) { this.pname = pname; }

    public User getOwner() { return user; }
    public void setOwner(User owner2) { this.user = owner2; }

    public void setPublic(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPublic'");
    }
}

