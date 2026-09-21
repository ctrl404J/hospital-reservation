package com.hospital.hospitalreservation.controller;

import com.hospital.hospitalreservation.dto.DoctorDto;
import com.hospital.hospitalreservation.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public void join(@RequestBody DoctorDto doctorDto){
        doctorService.join(doctorDto);
    }

    @GetMapping
    public List<DoctorDto> getDoctors(){
        return doctorService.getDoctors();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody DoctorDto doctorDto){
        doctorService.update(id, doctorDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }

}
