package com.sks.boardserver.boardreply.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
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
    @Column(name = "BOARD_NO", length = 30, nullable = false)
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
    // 대댓글을 위한 연관관계 설정



}
