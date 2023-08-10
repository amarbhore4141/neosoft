package com.example.crudJpa.service;

import com.example.crudJpa.dto.SkillsDto;
import org.springframework.http.ResponseEntity;

public interface SkillService {
    ResponseEntity<String> addSkills(SkillsDto skills);
}
