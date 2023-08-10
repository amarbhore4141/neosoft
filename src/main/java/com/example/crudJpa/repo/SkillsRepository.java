package com.example.crudJpa.repo;

import com.example.crudJpa.entity.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity, Integer> {
    SkillsEntity findBySkillName(String skillName);
}
