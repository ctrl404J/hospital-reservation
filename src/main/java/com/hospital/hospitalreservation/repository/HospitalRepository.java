package com.hospital.hospitalreservation.repository;

import com.hospital.hospitalreservation.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
