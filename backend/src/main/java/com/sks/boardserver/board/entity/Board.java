package com.sks.boardserver.board.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BOARD")
@Builder
public class Board {
    /** 글번호  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false, updatable = false)
    private int no;

    /** 글 작성자  */
    @Column(name = "WRITER", length = 30, nullable = false)
    private String writer;

    /** 글 제목  */
    @Column(name = "TITLE", nullable = false) // 정해주지 않으면 기본 길이는 255
    private String title;

    /** 글 내용  */
    @Column(name = "CONTENT", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    /** 글 작성 날짜  */
    @Column(name = "WRITE_DATE", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;

    /** 글 들여쓰기 순서 default = 0 */
    @Column(name = "SEQ", nullable = false)
    private int seq;

    /** 글 삭제 여부 default = false */
    @Column(name = "IS_DELETE", nullable = false, columnDefinition = "TINYINT(4)")
    private boolean isDelete;

    /** 조회수 default : 0   */
    @Column(name = "VIEW", nullable = false)
    private int view;

    /** 추천 수 default = 0  */
    @Column(name = "RECOMMEND", nullable = false)
    private int recommend;

    /** 부모 글 번호 = 기본 null 값  */
    @Column(name = "PARENT_NO")
    private int parentNo;
    
    /** 이미지 파일 루트  */
    @Column(name = "IMG_ROUTE")
    private String imgRoute;


}
