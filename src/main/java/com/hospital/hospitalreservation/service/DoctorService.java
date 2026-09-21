package com.hospital.hospitalreservation.service;

import com.hospital.hospitalreservation.domain.Doctor;
import com.hospital.hospitalreservation.domain.Hospital;
import com.hospital.hospitalreservation.dto.DoctorDto;
import com.hospital.hospitalreservation.repository.DoctorRepository;
import com.hospital.hospitalreservation.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    public DoctorService(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public void join(DoctorDto doctorDto){
        Hospital hospital = hospitalRepository.findById(doctorDto.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 병원정보입니다."));
        Doctor doctor = new Doctor(
                doctorDto.getName(),
                doctorDto.getSpecialty(),
                hospital
        );
        doctorRepository.save(doctor);
    }

    public List<DoctorDto> getDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorList = new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorList.add(new DoctorDto(doctor));
        }
        return doctorList;
    }

    @Transactional
    public void update(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 병원정보입니다."));
        doctor.updateInfo(
                doctorDto.getName(),
                doctorDto.getSpecialty()
        );
    }

    public void delete(Long id) {
        Doctor doctor = doctorRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("존재하지 않는 의사정보입니다."));
        doctorRepository.delete(doctor);
    }
}
