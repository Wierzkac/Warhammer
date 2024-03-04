package com.warhammer.alfa.models.Career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CareerService {


    final private CareerRepository careerRepository;

    CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<CareerDTO> getAllCareers() {
        List<Career> careers = (List<Career>) careerRepository.findAllWithCareers();
        return careers.stream().map(this::convertToDTO).toList();
    }

    public CareerDTO getCareer(int id) {
        return convertToDTO(careerRepository.findById(id).orElseThrow());
    }

    public void createNewCareer(Career newCareer) {
        careerRepository.save(newCareer);
    }

    public void updateCareer(int id, Career career) {
        careerRepository.save(career);
    }

    public void deleteCareer(int id) {
        careerRepository.deleteById(id);
    }

    

    private CareerDTO convertToDTO(Career career) {
        CareerDTO careerDTO = new CareerDTO();
        careerDTO.setId(career.getId());
        careerDTO.setName(career.getName());
        careerDTO.setDescription(career.getDescription());
        
        List<Map<String, String>> careerEntries = new ArrayList<>();
        career.getCareerEntries().stream().forEach(entry -> {
            Map<String, String> subCareerEntry = new HashMap<>();
            subCareerEntry.put("id", String.valueOf(entry.getId()));
            subCareerEntry.put("name", entry.getName());
            careerEntries.add(subCareerEntry);
        });
        careerDTO.setCareerEntries(careerEntries);
        
        List<Map<String, String>> careerExits = new ArrayList<>();
        career.getCareerExits().stream().forEach(entry -> {
            Map<String, String> subCareerExit = new HashMap<>();
            subCareerExit.put("id", String.valueOf(entry.getId()));
            subCareerExit.put("name", entry.getName());
            careerExits.add(subCareerExit);
        });
        careerDTO.setCareerExits(careerExits);

        return careerDTO;
    }
}
