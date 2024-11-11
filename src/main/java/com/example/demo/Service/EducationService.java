package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Education;
import com.example.demo.Repository.EducationRepository;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public void saveEducation(Education education) {
        educationRepository.save(education);
    }
}
