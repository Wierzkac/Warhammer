package com.warhammer.alfa.models.Talent;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TalentService {

    final private TalentRepository talentRepository;

    TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public List<Talent> getAllTalents() {
        return (List<Talent>) talentRepository.findAll();
    }

    public Talent getTalent(int id) {
        return talentRepository.findById(id).orElseThrow();
    }

    public void createNewTalent(Talent newTalent) {
        talentRepository.save(newTalent);
    }

    public void updateTalent(int id, Talent talent) {
        talentRepository.save(talent);
    }

    public void deleteTalent(int id) {
        talentRepository.deleteById(id);
    }
}
