package com.hospital.hospitalreservation.repository;

import com.hospital.hospitalreservation.domain.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}
