package com.warhammer.alfa.models.Career;

import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("careers")
public class CareerController {

    final private CareerService careerService;

    CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping
    public List<CareerDTO> getAllCareers() {
        return careerService.getAllCareers();
    }

    @GetMapping("/{id}")
    public CareerDTO getCareer(@PathVariable int id) {
        return careerService.getCareer(id);
    }

    @PostMapping("/")
    public void createNewCareer(@RequestBody Career newCareer) {
        careerService.createNewCareer(newCareer);
    }

    @PutMapping("/{id}")
    public void updateCareer(@PathVariable int id, @RequestBody Career career) {
        careerService.updateCareer(id, career);
    }

    @DeleteMapping("/{id}")
    public void deleteCareer(@PathVariable int id) {
        careerService.deleteCareer(id);
    }
}