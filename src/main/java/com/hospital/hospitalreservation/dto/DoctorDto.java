package com.hospital.hospitalreservation.dto;

import com.hospital.hospitalreservation.domain.Doctor;

public class DoctorDto {

    private Long id;
    private String name;
    private String specialty;

    public DoctorDto() {
    }

    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.specialty = doctor.getSpecialty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
