package com.hospital.hospitalreservation.service;

import com.hospital.hospitalreservation.domain.Member;
import com.hospital.hospitalreservation.dto.MemberRequest;
import com.hospital.hospitalreservation.dto.MemberResponse;
import com.hospital.hospitalreservation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers(){

        List<MemberResponse> responseList = new ArrayList<>();
        List<Member> members = memberRepository.findAll();

        for(Member member : members){
            responseList.add(new MemberResponse(member));
        }

        return responseList;
    }

}
