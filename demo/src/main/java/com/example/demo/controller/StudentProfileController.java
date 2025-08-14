package com.example.demo.controller;

import com.example.demo.services.StudentProfileService;
import com.example.demo.studentprofile.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentProfileController {
    private StudentProfileService studentProfileService;
    @Autowired
    public StudentProfileController(StudentProfileService studentProfileService){
        this.studentProfileService = studentProfileService;
    }
    @PostMapping("/studentprofile/create")
    public String create(@RequestBody StudentProfile studentProfile){
        studentProfileService.createStudentProfile(studentProfile);
        return "Student profile is successfully stored";
    }
    @GetMapping("/studentprofile/{studentId}")
    public StudentProfile get(@PathVariable Long studentId){
        return studentProfileService.getStudentProfileById(studentId);

    }

    // Delete
    @DeleteMapping("/studentprofile/{studentId}")
    public String delete(@PathVariable Long studentId){
        return "Student profile deleted successfully";

    }
    // put
    @PutMapping("/studentprofile/{studentId}")
    public String update(@PathVariable Long studentId, @RequestBody StudentProfile updatedProfile) {
        return "Student profile updated successfully";
}}
