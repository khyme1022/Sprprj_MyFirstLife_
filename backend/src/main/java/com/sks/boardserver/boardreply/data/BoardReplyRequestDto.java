package com.sks.boardserver.boardreply.data;

import com.sks.boardserver.boardreply.entity.BoardReply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardReplyRequestDto {
    private int replyNO;
    private int boardNo;
    private String writer;
    private String content;
    private LocalDateTime writeDate;
    private boolean isDelete;
    private int recommend;

    // request To Dto 생성자
    // Controller
    public BoardReplyRequestDto(HttpServletRequest request, int boardNum) throws ParseException{
        this.writer = request.getParameter("writer");
        this.content = request.getParameter("content");
        this.boardNo = boardNum;
    }
    // Dto To BoardReply
    public BoardReply toEntity(){
        return BoardReply.builder()
                .replyNo(replyNO)
                .boardNo(boardNo)
                .writer(writer)
                .content(content)
                .writeDate(writeDate)
                .isDelete(isDelete)
                .recommend(recommend)
                .build();
    }
}
