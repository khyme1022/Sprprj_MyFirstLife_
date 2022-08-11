package com.sks.boardserver.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    /**
     * email 값으로 DB에서 회원 정보를 가져와 반환
     */
    public MemberDto getMemberByEmail(String email){
        Member member = memberRepository.findMemberByEmail(email);
        return new MemberDto(member);
    }

    /**
     * Member 객체를 만들어서 DB에 insert
     */
    public void addMemberInfo(HttpServletRequest request) throws ParseException {
        Member member = new MemberDto(request).toEntity();
        memberRepository.save(member);
    }
}
