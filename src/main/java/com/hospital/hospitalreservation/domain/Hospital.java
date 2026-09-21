package com.hospital.hospitalreservation.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "hospitals")
@SQLDelete(sql = "UPDATE hospitals SET is_deleted = true WHERE hospital_id = ?")
@SQLRestriction("is_deleted = false")
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
