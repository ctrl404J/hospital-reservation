package com.hospital.hospitalreservation.controller;

import com.hospital.hospitalreservation.dto.MemberRequest;
import com.hospital.hospitalreservation.dto.MemberResponse;
import com.hospital.hospitalreservation.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberResponse> getMembers(){
        return memberService.getMembers();
    }

}
