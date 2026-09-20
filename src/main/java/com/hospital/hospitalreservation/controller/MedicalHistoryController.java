package com.hospital.hospitalreservation.controller;

import com.hospital.hospitalreservation.dto.MedicalHistoryDto;
import com.hospital.hospitalreservation.service.MedicalHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medicalHistories")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService){
        this.medicalHistoryService = medicalHistoryService;
    }

    @PostMapping
    public void save(@RequestBody MedicalHistoryDto medicalHistoryDto){
        medicalHistoryService.save(medicalHistoryDto);
    }

    @GetMapping
    public List<MedicalHistoryDto> getMedicalHistories(){
        return medicalHistoryService.getMedicalHistories();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody MedicalHistoryDto medicalHistoryDto){
        medicalHistoryService.update(id, medicalHistoryDto);
    }

}
