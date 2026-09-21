package com.hospital.hospitalreservation.controller;

import com.hospital.hospitalreservation.domain.Hospital;
import com.hospital.hospitalreservation.dto.HospitalDto;
import com.hospital.hospitalreservation.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @PostMapping
    public void save(@RequestBody HospitalDto hospitalDto){
        hospitalService.save(hospitalDto);
    }

    @GetMapping
    public List<HospitalDto> getHospitals(){
        return hospitalService.getHospitals();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody HospitalDto hospitalDto){
        hospitalService.update(id, hospitalDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        hospitalService.delete(id);
    }

}
