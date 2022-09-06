package com.sks.boardserver.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    /**
     * email 값으로 DB에서 회원 정보를 가져와 {@link MemberDto} 객체로 반환
     */
    public MemberDto getMemberDtoByEmail(String email){
        Member member = memberRepository.findMemberByEmail(email);
        if(member.getBirthDate() != null){
            return null;
        }
        return new MemberDto(member);
    }

    /**
     * Member 객체를 만들어서 DB에 insert
     */
    @Transactional
    public MemberDto addMemberInfo(HttpServletRequest request) {
        Member member;
        try {
            member = new MemberDto(request).toEntity();
        } catch (Exception e){
            return null;
        }
        memberRepository.save(member);
        return new MemberDto(member);
    }

    /**
     * email 기반으로 회원 정보에서 매핑되는 id 값을 가져 온 후
     * 해당 id로 회원 정보를 delete
     */
    @Transactional
    public boolean deleteMemberInfoByEmail(String email) {
        Member member = memberRepository.findMemberByEmail(email);
        if(member.getDeleteDate() == null) {
            memberRepository.updateMemberDeleteDate(member.getId(), new Date());
        }else{
            return false;
        }
        return true;
    }

    @Transactional
    public MemberDto modifyMemberInfo(HttpServletRequest request, String email) {
        MemberDto memberDto;
        try {
            memberDto = new MemberDto(memberRepository.findMemberByEmail(email));
            if (memberRepository.findMemberByEmail(memberDto.getEmail()) == null) {
                return null;
            }
            memberDto.modify(request);
            Member member = memberDto.toEntity();
            memberRepository.updateMemberInfo(member.getId(), member.getPwd(), member.getIntroduce(), member.getBirthDate(), member.isGender(), member.isOpenPostInfo());
        } catch (Exception e){
            return null;
        }
        return memberDto;
    }
}
