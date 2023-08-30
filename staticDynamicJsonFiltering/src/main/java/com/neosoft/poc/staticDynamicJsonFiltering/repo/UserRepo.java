package com.neosoft.poc.staticDynamicJsonFiltering.repo;

import com.neosoft.poc.staticDynamicJsonFiltering.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
}
