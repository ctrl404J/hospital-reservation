package com.hospital.hospitalreservation.dto;

import com.hospital.hospitalreservation.domain.Hospital;

public class HospitalDto {

    private Long id;
    private String name;
    private String address;
    private String tel;

    public HospitalDto() {
    }

    public HospitalDto(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.address = hospital.getAddress();
        this.tel = hospital.getTel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
