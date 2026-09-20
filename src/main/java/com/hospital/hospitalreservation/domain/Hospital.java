package com.hospital.hospitalreservation.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 20)
    private String tel;

    protected Hospital() {
    }

    public Hospital(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public void updateInfo(String name, String address, String tel){
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

}
