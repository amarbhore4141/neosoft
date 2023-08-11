package com.example.crudJpa.service.serviceImpl;

import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.SkillsEntity;
import com.example.crudJpa.repo.SkillsRepository;
import com.example.crudJpa.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SkillsEntity> getALL() {
        List<SkillsEntity> skillsEntityList=skillsRepository.findAll();

        //System.out.println(skillsRepository.findAll());
        return skillsEntityList;
    }

    @Override
    public void deleteById(int skillID) {
        if(skillsRepository.findById(skillID) == null ){
            //return response with message skill not present
        }else
            skillsRepository.deleteById(skillID);
        //return response

    }

    @Override
    public void updateSkillsById(int skillID, String skillName) {
        SkillsEntity skillsEntity=skillsRepository.findById(skillID).get();
        if(skillsRepository.findById(skillID) == null){
            //return response skill not found
        }else
            skillsEntity.setSkillName(skillName);
            skillsRepository.save(skillsEntity);

    }
}
