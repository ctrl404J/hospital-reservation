package com.hospital.hospitalreservation.service;

import com.hospital.hospitalreservation.domain.Doctor;
import com.hospital.hospitalreservation.domain.Member;
import com.hospital.hospitalreservation.domain.Reservation;
import com.hospital.hospitalreservation.dto.ReservationDto;
import com.hospital.hospitalreservation.repository.DoctorRepository;
import com.hospital.hospitalreservation.repository.MemberRepository;
import com.hospital.hospitalreservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final DoctorRepository doctorRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, DoctorRepository doctorRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.doctorRepository = doctorRepository;
    }

    public void save(ReservationDto reservationDto) {
        Member member = memberRepository.findById(reservationDto.getMemberId()).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원정보입니다."));
        Doctor doctor = doctorRepository.findById(reservationDto.getDoctorId()).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 의사정보입니다."));
        reservationRepository.save(new Reservation(
                reservationDto.getReservationDate(),
                reservationDto.getReservationTime(),
                reservationDto.getStatus(),
                member,
                doctor
        ));
    }

    public List<ReservationDto> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservationDtoList.add(new ReservationDto(reservation));
        }
        return reservationDtoList;
    }

    @Transactional
    public void update(Long id, ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예약정보입니다."));
        reservation.updateInfo(
                reservationDto.getReservationDate(),
                reservationDto.getReservationTime(),
                reservationDto.getStatus()
        );
    }

    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("존재하지 않는 예약정보입니다."));
        reservationRepository.delete(reservation);
    }
}
