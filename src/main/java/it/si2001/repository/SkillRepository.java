package it.si2001.repository;

import it.si2001.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {

    Skill findBySkill(String skill);
}
