package com.hospital.hospitalreservation.dto;

import com.hospital.hospitalreservation.domain.MedicalHistory;

public class MedicalHistoryDto {

    private Long id;
    private String diagnosis;
    private String prescription;
    private Long reservationId;

    public MedicalHistoryDto() {
    }

    public MedicalHistoryDto(MedicalHistory medicalHistory) {
        this.id = medicalHistory.getId();
        this.diagnosis = medicalHistory.getDiagnosis();
        this.prescription = medicalHistory.getPrescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Long getReservationId() {
        return reservationId;
    }

}
