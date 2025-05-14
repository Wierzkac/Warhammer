package com.warhammer.alfa.models.Talent;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TalentService {

    final private TalentRepository talentRepository;
    final private TalentMapper talentMapper;

    TalentService(TalentRepository talentRepository, TalentMapper talentMapper) {
        this.talentRepository = talentRepository;
        this.talentMapper = talentMapper;
    }

    public List<TalentDTO> getAllTalents() {
        List<Talent> talents = talentRepository.findAll();
        return talentMapper.toDTOList(talents);
    }

    public TalentDTO getTalent(int id) {
        return talentMapper.toDTO(talentRepository.findById(id).orElseThrow());
    }
}
