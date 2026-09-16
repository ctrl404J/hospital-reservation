package com.hospital.hospitalreservation.dto;

import com.hospital.hospitalreservation.domain.Member;
import com.hospital.hospitalreservation.domain.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDto {

    private Long id;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String status;

    public ReservationDto(){
    }

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.reservationDate = reservation.getReservationDate();
        this.reservationTime = reservation.getReservationTime();
        this.status = reservation.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
