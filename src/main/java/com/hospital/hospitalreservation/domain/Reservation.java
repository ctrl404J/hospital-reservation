package com.hospital.hospitalreservation.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "reservation_time", nullable = false)
    private LocalTime reservationTime;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    protected Reservation(){
    }

    public Reservation(LocalDate reservationDate, LocalTime reservationTime, String status, Member member, Doctor doctor){
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;
        this.member = member;
        this.doctor = doctor;
    }

    public void updateInfo(LocalDate reservationDate, LocalTime reservationTime, String status){
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public String getStatus() {
        return status;
    }

    public Member getMember() {
        return member;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
