package com.example.crudJpa.controller;

import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.service.EmployeeService;
import com.example.crudJpa.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {
    @Autowired
    SkillService skillService;

    @PostMapping("/addSkills")
    public ResponseEntity<String> addSkills(@RequestBody SkillsDto skills)
    {
        System.out.println(skills);
        return skillService.addSkills(skills);
    }
}
