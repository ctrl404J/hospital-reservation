package com.hospital.hospitalreservation.repository;

import com.hospital.hospitalreservation.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
