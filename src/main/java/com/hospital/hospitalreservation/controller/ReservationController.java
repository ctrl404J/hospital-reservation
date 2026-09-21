package com.hospital.hospitalreservation.controller;

import com.hospital.hospitalreservation.dto.ReservationDto;
import com.hospital.hospitalreservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping
    public void save(@RequestBody ReservationDto reservationDto){
        reservationService.save(reservationDto);
    }

    @GetMapping
    public List<ReservationDto> getReservations(){
        return reservationService.getReservations();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ReservationDto reservationDto){
        reservationService.update(id, reservationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.delete(id);
    }

}
