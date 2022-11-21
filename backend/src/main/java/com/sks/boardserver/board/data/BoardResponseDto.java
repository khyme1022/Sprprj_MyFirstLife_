package com.sks.boardserver.board.data;

import com.sks.boardserver.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private int no;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private boolean isDelete;
    private int view;
    private int recommend;
    private String imgRoute;


    /**
     * Board(Entity) to BoardDto 생성자
     */
    public BoardResponseDto(Board board){
        this.no = board.getNo();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writeDate = board.getWriteDate();
        this.isDelete = board.isDelete(); // boolean 타입은 롬복 사용시 isXXX 형태로 생성
        this.view = board.getView();
        this.recommend = board.getRecommend();
        this.imgRoute = board.getImgRoute();
    }
}
