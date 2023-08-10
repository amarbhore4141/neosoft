package com.example.crudJpa.service.serviceImpl;

import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.SkillsEntity;
import com.example.crudJpa.repo.SkillsRepository;
import com.example.crudJpa.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public ResponseEntity<String> addSkills(SkillsDto skills)
    {
        String msg="";
        System.out.println(skills);
        SkillsEntity se=new SkillsEntity();

        SkillsEntity existingSkill=skillsRepository.findBySkillName(skills.getSkillName());

        if(existingSkill != null){
            msg="Skills already present";

        }else {
            SkillsEntity addNewSkill=new SkillsEntity();
            addNewSkill.setSkillName(skills.getSkillName().toUpperCase());
            skillsRepository.save(addNewSkill);
            msg="skill added successfully!";}

        return ResponseEntity.ok(msg);
    }
}
