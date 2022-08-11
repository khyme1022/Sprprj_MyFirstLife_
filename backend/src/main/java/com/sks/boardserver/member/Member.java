package com.sks.boardserver.member;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/** 회원 entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MEMBER")
@Builder
public class Member {

    /** 사용자 계정 아이디 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private int id;

    /** 사용자 계정 패스워드 */
    @Setter
    @Column(name = "PWD", length = 30, nullable = false)
    private String pwd;

    /** 이메일 */
    @Getter
    @Setter
    @Column(name = "EMAIL", nullable = false, unique = true) // 정해주지 않으면 기본 길이는 255
    private String email;

    /** 이름 */
    @Getter
    @Setter
    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    /** 자기 소개 */
    @Getter
    @Setter
    @Column(name = "INTRODUCE")
    private String introduce;

    /** 생년월일 */
    @Getter
    @Setter
    @Column(name = "BIRTH", columnDefinition = "DATETIME", nullable = false) // columnDefinition을 사용하면 원하는 타입으로 데이터 추출이 가능하다함
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입을 매핑 할 때 사용
    private Date birth;

    /**
     * 성별
     * <ul>
     *     <li> true : 남자</li>
     *     <li> false : 여자</li>
     * </ul>
     * */
    @Getter
    @Setter
    @Column(name = "GENDER", nullable = false, columnDefinition = "TINYINT(4)")
    private boolean gender;

    /**
     * 회원 글 목록 공개
     * <ul>
     *     <li> true : 공개</li>
     *     <li> false : 비공개</li>
     * </ul>
     * */
    @Getter
    @Setter
    @Column(name = "OPEN_POST_INFO", nullable = false, columnDefinition = "TINYINT(4)")
    private boolean openPostInfo;
}
