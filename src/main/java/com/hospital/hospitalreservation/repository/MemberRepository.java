package com.hospital.hospitalreservation.repository;

import com.hospital.hospitalreservation.domain.Member;
import com.hospital.hospitalreservation.dto.MemberResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
