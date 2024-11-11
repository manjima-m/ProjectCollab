package com.example.demo.Service;



import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private ProjectRepository projectRepository;

    // Find the project by ID
    public ProjectOwner findProjectById(Integer projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    // Send application letter to the project owner
    public void sendApplicationToOwner(User projectOwner, String applicationLetter) {
        if (projectOwner == null || projectOwner.getEmail() == null) {
            // Handle case where no owner is found or email is missing
            return;
        }

        // Create and send an email with the application letter
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(projectOwner.getEmail());
        message.setSubject("New Application for Your Project");
        message.setText("You have received a new application for your project. Here's the letter:\n\n" + applicationLetter);

        mailSender.send(message);
    }
}
