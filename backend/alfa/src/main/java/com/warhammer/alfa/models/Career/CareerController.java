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
}