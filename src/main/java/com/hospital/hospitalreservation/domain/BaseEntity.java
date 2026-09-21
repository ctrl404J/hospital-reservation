package com.hospital.hospitalreservation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "is_Deleted", nullable = false)
    private boolean isDeleted = false;

    public void restore(){
        this.isDeleted = false;
    }

    public boolean isDeleted(){
        return isDeleted;
    }

}
