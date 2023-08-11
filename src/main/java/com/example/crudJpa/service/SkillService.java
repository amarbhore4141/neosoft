package com.example.crudJpa.service;

import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.SkillsEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillService {
    ResponseEntity<String> addSkills(SkillsDto skills);

    List<SkillsEntity> getALL();

    void deleteById(int skillID);

    void updateSkillsById(int skillID, String skillName);
}
