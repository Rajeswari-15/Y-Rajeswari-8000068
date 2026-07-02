package com.cognizant.orm_learn_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_final.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}