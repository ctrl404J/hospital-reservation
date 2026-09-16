package com.hospital.hospitalreservation.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_histories")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    @Column(nullable = false)
    private String diagnosis;

    @Column(nullable = false)
    private String prescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;

    protected MedicalHistory() {
    }

    public MedicalHistory(String diagnosis, String prescription, Reservation reservation) {
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.reservation = reservation;
    }

    public Long getId() { return id; }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public Reservation getReservation() {
        return reservation;
    }

}
