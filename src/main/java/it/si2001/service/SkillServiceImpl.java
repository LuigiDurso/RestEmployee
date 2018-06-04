package it.si2001.service;

import it.si2001.model.Skill;
import it.si2001.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillService {

    final
    SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository=skillRepository;
    }

    @Override
    public Optional<Skill> findById(int id) {
        return this.skillRepository.findById(id);
    }

    @Override
    public Skill findByName(String name) {
        return this.skillRepository.findBySkill(name);
    }

    @Override
    public List<Skill> findAllSkills() {
        return (List<Skill>) this.skillRepository.findAll();
    }
}
