package com.sks.boardserver.boardreply.data;

import com.sks.boardserver.boardreply.entity.BoardReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardReplyResponseDto {
    private int replyNO;
    private int boardNo;
    private String writer;
    private String content;
    private LocalDateTime writeDate;
    private boolean isDelete;
    private int recommend;

    // Entity To Dto 메소드
    @Builder
    public BoardReplyResponseDto(BoardReply boardReply){
        this.replyNO = boardReply.getReplyNo();
        this.boardNo = boardReply.getBoardNo();
        this.writer = boardReply.getWriter();
        this.content = boardReply.getContent();
        this.writeDate = boardReply.getWriteDate();
        this.isDelete = boardReply.isDelete();
        this.recommend = boardReply.getRecommend();
    }

}
