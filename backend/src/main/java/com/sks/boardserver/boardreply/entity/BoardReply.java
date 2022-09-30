package com.sks.boardserver.boardreply.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
    reply_no : 댓글 번호
    board_no : 댓글 달린 글 번호
    writer : 댓글 작성자
    content : 댓글 내용
    date : 작성 날짜
    isDelete : 삭제 여부
    recommend : 추천 수

    대댓글 전용 컬럼
    order : 순서 
    parent_no : 부모 댓글 넘버
    
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "REPLY_BOARD")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class BoardReply {
    // 댓글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO", nullable = false,updatable = false)
    private int replyNo;
    // 댓글 달린 글 번호
    @Column(name = "BOARD_NO", nullable = false, updatable = false)
    private int boardNo;
    // 댓글 작성자
    @Column(name = "REPLY_WRITER", length = 30, nullable = false)
    private String writer;
    // 댓글
    @Column(name = "REPLY_CONTENT", nullable = false, columnDefinition = "LONGTEXT")
    private String content;
    // 작성날짜
    @CreatedDate
    @Column(name = "REPLY_WRITE_DATE", columnDefinition = "DATETIME", nullable = false, updatable = false)
    private LocalDateTime writeDate;
    // 댓글 삭제 여부
    @Column(name = "REPLY_IS_DELETE", nullable = false, columnDefinition = "TINYINT(4) default 0")
    private boolean isDelete;
    // 추천 수
    @Column(name = "REPLY_RECOMMEND", nullable = false, columnDefinition = "Integer default 0")
    private int recommend;

    @Column(name = "ORDER")
    private int order;

    @Column(name = "REPLY_PARENT_NO")
    private int parentNo;

}
