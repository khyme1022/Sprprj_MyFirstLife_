package com.sks.boardserver.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.mock.web.MockHttpServletRequest;

import java.text.ParseException;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
    @Mock MemberRepository memberRepository;
    @InjectMocks @Spy MemberService memberService;

    /**
     * 요청 값 그대로 MemberDto 값이 생성되었는지 검증하는 테스트
     */
    @Test
    public void testAddMemberInfo() {
        // Given
        String testEmail = "testEmail";
        String testPwd = "testPwd";
        String testName = "testName";
        String testIntroduce = "testIntroduce";
        String testBirth = "2022-09-06";
        String testGender = "M";
        String testOpenPostInfo = "true";

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setParameter("email", testEmail);
        mockHttpServletRequest.setParameter("pwd", testPwd);
        mockHttpServletRequest.setParameter("name", testName);
        mockHttpServletRequest.setParameter("introduce", testIntroduce);
        mockHttpServletRequest.setParameter("birth", testBirth);
        mockHttpServletRequest.setParameter("gender", testGender);
        mockHttpServletRequest.setParameter("openPostInfo", testOpenPostInfo);

        when(memberRepository.save(any(Member.class))).thenAnswer(invocationOnMock -> mock(Member.class));

        // When
        MemberDto actual = memberService.addMemberInfo(mockHttpServletRequest);

        // Then
        assertEquals(testEmail, actual.getEmail());
        assertEquals(testName, actual.getName());
        assertEquals(testIntroduce, actual.getIntroduce());
        assertEquals(Gender.MALE, actual.getGender());
        assertTrue(actual.isOpenPostInfo());
    }

    /**
     * 수정 된 MemberDto 값이 반환 되는지 검증하는 테스트
     */
    @Test
    public void modifyMemberInfo() throws ParseException {
        // Given
        String testEmail = "testEmail";
        String testPwd = "testPwd";
        String testName = "testName";
        String testIntroduce = "testIntroduce";
        String testBirth = "2022-09-06";
        String testGender = "M";
        String testOpenPostInfo = "true";

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setParameter("email", testEmail);
        mockHttpServletRequest.setParameter("pwd", testPwd);
        mockHttpServletRequest.setParameter("name", testName);
        mockHttpServletRequest.setParameter("introduce", testIntroduce);
        mockHttpServletRequest.setParameter("birth", testBirth);
        mockHttpServletRequest.setParameter("gender", testGender);
        mockHttpServletRequest.setParameter("openPostInfo", testOpenPostInfo);
        Member member = new MemberDto(mockHttpServletRequest).toEntity();
        when(memberRepository.findMemberByEmail(testEmail)).thenReturn(member);
        doNothing().when(memberRepository).updateMemberInfo(anyInt(), anyString(), anyString(), any(Date.class), anyBoolean(), anyBoolean());

        String expectIntroduce = "expectIntroduce";
        mockHttpServletRequest.setParameter("introduce", expectIntroduce);
        mockHttpServletRequest.setParameter("gender", "F");
        mockHttpServletRequest.setParameter("openPostInfo", "false");

        // When
        MemberDto actual = memberService.modifyMemberInfo(mockHttpServletRequest, testEmail);

        // Then
        assertEquals(expectIntroduce, actual.getIntroduce());
        assertEquals(Gender.FEMALE, actual.getGender());
        assertFalse(actual.isOpenPostInfo());
    }

    /**
     * Member 객체의 deleteDate가 null일 때 updateMemberDeleteDate 함수를 호출하는지 검증하는 테스트
     */
    @Test
    public void testDeleteMemberInfoByEmailDeleteDateIsNull(){
        // Given
        String testEmail = "testEmail";
        Member mockMember = mock(Member.class);
        doReturn(mockMember).when(memberRepository).findMemberByEmail(testEmail);
        doReturn(null).when(mockMember).getDeleteDate();
        doNothing().when(memberRepository).updateMemberDeleteDate(anyInt(), any(Date.class));

        // When
        boolean actual = memberService.deleteMemberInfoByEmail(testEmail);

        // Then
        assertTrue(actual);
        verify(memberRepository, times(1)).updateMemberDeleteDate(anyInt(), any(Date.class));
    }

    /**
     * Member 객체의 deleteDate가 null이 아닐 때 updateMemberDeleteDate 함수를 호출하지 않는지 검증하는 테스트
     */
    @Test
    public void testDeleteMemberInfoByEmailDeleteDateIsNotNull(){
        // Given
        String testEmail = "testEmail";
        Member mockMember = mock(Member.class);
        doReturn(mockMember).when(memberRepository).findMemberByEmail(testEmail);
        doReturn(new Date()).when(mockMember).getDeleteDate();

        // When
        boolean actual = memberService.deleteMemberInfoByEmail(testEmail);

        // Then
        assertFalse(actual);
        verify(memberRepository, never()).updateMemberDeleteDate(anyInt(), any(Date.class));
    }
}