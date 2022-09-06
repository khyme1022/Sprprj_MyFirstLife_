package com.sks.boardserver.member;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;

    /**
     * email 값을 기반으로 회원 정보를 가져옴
     *
     * @param email 가져올 회원의 email
     */
    @GetMapping(value = "/member/{email}")
    public ResponseEntity<MemberDto> getMember(@PathVariable(value = "email") String email){
        if(StringUtils.isBlank(email)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(memberService.getMemberDtoByEmail(email));
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
    public ResponseEntity<MemberDto> addMember(HttpServletRequest request){
        return ResponseEntity.ok(memberService.addMemberInfo(request));
    }

    /**
     * email 값을 기반으로 회원 정보를 찾아 제거함
     * <p>데이터를 delete 하지는 않고 deleteDate를 업데이트 함</p>
     */
    @DeleteMapping(value = "/member/{email}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable(value = "email") String email){
        boolean isDelete = memberService.deleteMemberInfoByEmail(email);
        if(StringUtils.isBlank(email)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(isDelete);
    }

    /**
     * email 값을 기반으로 회원 정보를 찾아 정보를 업데이트 함
     * <p>업데이트 가능한 값은 아래와 같음</p>
     * <ul>
     *     <li>패스워드</li>
     *     <li>소개말</li>
     *     <li>생일</li>
     *     <li>성별</li>
     *     <li>게시글 공개 여부</li>
     * </ul>
     */
    @PutMapping(value = "/member/{email}")
    public ResponseEntity<MemberDto> modifyMemberInfo(@PathVariable(value = "email") String email, HttpServletRequest request){
        MemberDto memberDto = memberService.modifyMemberInfo(request, email);
        if(StringUtils.isBlank(email)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(memberDto);
    }
}
