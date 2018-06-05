package it.si2001.service;

import it.si2001.model.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService
{
    Optional<Skill> findById(int id);

    Skill findByName(String name);

    List<Skill> findAllSkills();
}
