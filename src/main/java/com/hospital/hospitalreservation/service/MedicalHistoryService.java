package com.hospital.hospitalreservation.service;

import com.hospital.hospitalreservation.domain.MedicalHistory;
import com.hospital.hospitalreservation.domain.Reservation;
import com.hospital.hospitalreservation.dto.MedicalHistoryDto;
import com.hospital.hospitalreservation.repository.MedicalHistoryRepository;
import com.hospital.hospitalreservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final ReservationRepository reservationRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository, ReservationRepository reservationRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.reservationRepository = reservationRepository;
    }

    public void save(MedicalHistoryDto medicalHistoryDto) {
        Reservation reservation = reservationRepository.findById(medicalHistoryDto.getReservationId()).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예약정보입니다."));
        medicalHistoryRepository.save(new MedicalHistory(
                medicalHistoryDto.getDiagnosis(),
                medicalHistoryDto.getPrescription(),
                reservation
        ));
    }

    public List<MedicalHistoryDto> getMedicalHistories(){
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findAll();
        List<MedicalHistoryDto> medicalHistoryDtoList = new ArrayList<>();
        for(MedicalHistory medicalHistory : medicalHistories){
            medicalHistoryDtoList.add(new MedicalHistoryDto(medicalHistory));
        }
        return medicalHistoryDtoList;
    }

    @Transactional
    public void update(Long id, MedicalHistoryDto medicalHistoryDto) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 진료기록입니다."));
        medicalHistory.updateInfo(
                medicalHistoryDto.getDiagnosis(),
                medicalHistoryDto.getPrescription()
        );
    }

    public void delete(Long id) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("존재하지 않는 진료기록입니다."));
        medicalHistoryRepository.delete(medicalHistory);
    }
}
