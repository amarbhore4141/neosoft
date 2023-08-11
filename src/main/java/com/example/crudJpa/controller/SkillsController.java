package com.example.crudJpa.controller;

import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.SkillsEntity;
import com.example.crudJpa.service.EmployeeService;
import com.example.crudJpa.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/skills")
@RestController
public class SkillsController {
    @Autowired
    SkillService skillService;

    @PostMapping("")
    public ResponseEntity<String> addSkills(@RequestBody SkillsDto skills)
    {
        System.out.println(skills);
        return skillService.addSkills(skills);
    }
    @GetMapping("")
    public List<SkillsEntity> showAllSkills(){
        List<SkillsEntity> skillList= skillService.getALL();
        return skillList;
    }
    @DeleteMapping("/{skillID}")
    public void deleteSkill(@PathVariable int skillID){
        skillService.deleteById(skillID);
    }
    @PutMapping("/{skillID}")
    public void updateSkill(@PathVariable int skillID,@RequestParam String skillName){
        skillService.updateSkillsById(skillID,skillName);
    }
}
