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

    public BoardReplyDto(BoardReply boardReply){
        this.replyNo = boardReply.getReplyNo();
        this.boardNo = boardReply.getBoardNo();
        this.writer = boardReply.getWriter();
        this.content = boardReply.getContent();
        this.writeDate = boardReply.getWriteDate();
        this.isDelete = boardReply.isDelete();
        this.recommend = boardReply.getRecommend();
        this.order = boardReply.getOrder();
        this.parentNo = boardReply.getParentNo();

    }

    /**
     * 
     * @param request
     * @throws ParseException
     * 아마 계층형 DB 들여쓰기 생각해서 작성해야할듯
     */
    public BoardReplyDto(HttpServletRequest request) throws ParseException{
        this.boardNo = Integer.parseInt(request.getParameter("boardNo"));
        this.writer = request.getParameter("writer");
        this.content = request.getParameter("content");
        this.order = Integer.parseInt(request.getParameter("order"));
        this.parentNo = Integer.parseInt(request.getParameter("parentNo"));
    }

    public BoardReply toEntity(){
        return BoardReply.builder()
                .replyNo(replyNo)
                .boardNo(boardNo)
                .writer(writer)
                .content(content)
                .writeDate(writeDate)
                .isDelete(isDelete)
                .recommend(recommend)
                .order(order)
                .parentNo(parentNo)
                .build();
    }
}
