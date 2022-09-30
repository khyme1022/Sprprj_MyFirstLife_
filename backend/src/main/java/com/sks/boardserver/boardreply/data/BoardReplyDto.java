package com.sks.boardserver.boardreply.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardReplyDto {

    private int replyNo; // 댓글 번호
    private int boardNo; // 댓글 달린 글 번호
    private String writer; // 댓글 작성자
    private String content; // 댓글
    private LocalDateTime writeDate; // 작성날짜
    private boolean isDelete; // 댓글 삭제 여부
    private int recommend; // 추천 수

    private int order; // 글 순서
    private int parentNo; // 부모 글 번호
}
