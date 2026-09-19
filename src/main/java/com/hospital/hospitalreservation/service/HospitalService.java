package com.hospital.hospitalreservation.service;

import com.hospital.hospitalreservation.domain.Hospital;
import com.hospital.hospitalreservation.dto.HospitalDto;
import com.hospital.hospitalreservation.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public void save(HospitalDto hospitalDto) {
        hospitalRepository.save(new Hospital(
                hospitalDto.getName(),
                hospitalDto.getAddress(),
                hospitalDto.getTel()
        ));
    }

    public List<HospitalDto> getHospitals() {
        List<Hospital> hostpitals = hospitalRepository.findAll();
        List<HospitalDto> hospitalList = new ArrayList<>();
        for(Hospital hospital : hostpitals){
            hospitalList.add(new HospitalDto(hospital));
        }
        return hospitalList;
    }

    @Transactional
    public void update(Long id, HospitalDto hospitalDto) {
        Hospital hospital = hospitalRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 병원정보입니다."));
        hospital.updateInfo(
                hospitalDto.getName(),
                hospitalDto.getAddress(),
                hospitalDto.getTel()
        );
    }
}
