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

    @PostMapping
    public void join(@RequestBody MemberRequest request){
        memberService.join(request);
    }

    @GetMapping
    public List<MemberResponse> getMembers(){
        return memberService.getMembers();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,  @RequestBody MemberRequest request){
        memberService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }

}
