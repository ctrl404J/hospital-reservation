package com.hospital.hospitalreservation.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "doctors")
@SQLDelete(sql = "UPDATE doctors SET is_deleted = true WHERE doctor_id = ?")
@SQLRestriction("is_deleted = false")
public class Doctor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String specialty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    protected Doctor(){
    }

    public Doctor(String name, String specialty, Hospital hospital) {
        this.name = name;
        this.specialty = specialty;
        this.hospital = hospital;
    }

    public void updateInfo(String name, String specialty){
        this.name = name;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Hospital getHospital() {
        return hospital;
    }
}
