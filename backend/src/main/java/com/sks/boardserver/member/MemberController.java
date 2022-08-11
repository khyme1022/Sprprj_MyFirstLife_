package com.sks.boardserver.member;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
public class MemberController {
    @Autowired private MemberService memberService;

    /**
     * email 값을 기반으로 회원 정보를 가져옴
     * <ul>
     *     <li>이메일 파라미터를 주지 않았을 경우 : 405 에러(이건 스프링에서 주는 듯)</li>
     *     <li>이메일 파라미터에 공백을 주고 요청했을 경우 : 400 에러</li>
     *     <li>회원 정보가 없을 경우 : 500 에러(이건 수정해야 할 듯)</li>
     *     <li>가져온 멤버 값이 null 일 경우 : 404 에러</li>
     *     <li>회원 정보를 성공적으로 줬을 경우 : 200</li>
     * </ul>
     *
     * @param email 가져올 회원의 email
     */
    @GetMapping(value = "/member/{email}")
    public ResponseEntity<MemberDto> getMember(@PathVariable(value = "email") String email){
        if(StringUtils.isBlank(email)){
            return ResponseEntity.badRequest().build();
        }
        MemberDto memberDto = memberService.getMemberByEmail(email);
        if(memberDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memberDto);
    }

    /**
     * 회원 정보를 등록, 파라미터는 아래와 같음
     * <ul>
     *     <li>email : 회원 이메일</li>
     *     <li>pwd : 회원 패스워드(암호화 작업은 추후에)</li>
     *     <li>name : 회원 이름(닉네임?)</li>
     *     <li>introduce : 소개말</li>
     *     <li>birth : 생년월일(yyyy-MM-dd 형식)</li>
     *     <li>gender : 성별(M-남자 / F-여자)</li>
     *     <li>openPostInfo : 게시물 보여줄건지 여부(true/false)</li>
     * </ul>
     *
     */
    @PostMapping(value = "/member")
    public ResponseEntity<String> addMember(HttpServletRequest request){
        try {
            memberService.addMemberInfo(request);
        }catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.ok("success");
    }

}
