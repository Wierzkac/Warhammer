package com.warhammer.alfa.models.Career;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CareerService {

    final private CareerRepository careerRepository;
    final private CareerMapper careerMapper;

    CareerService(CareerRepository careerRepository, CareerMapper careerMapper) {
        this.careerRepository = careerRepository;
        this.careerMapper = careerMapper;
    }

    public List<CareerDTO> getAllCareers() {
        List<Career> careers = careerRepository.findAll();
        return careerMapper.toDTOList(careers);
    }

    public CareerDTO getCareer(int id) {
        return careerMapper.toDTO(careerRepository.findById(id).orElseThrow());
    }
}
