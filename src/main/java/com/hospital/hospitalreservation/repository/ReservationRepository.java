package com.hospital.hospitalreservation.repository;

import com.hospital.hospitalreservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
