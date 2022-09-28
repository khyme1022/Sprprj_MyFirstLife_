package com.sks.boardserver.board.data;

import com.sks.boardserver.board.entity.Board;
import lombok.*;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int no;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private boolean isDelete;
    private int view;
    private int recommend;
    private String imgRoute;

    public BoardDto(Board board){
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
    /**
     * DB에서 Dto로 변환하기 
     * Board entity 값을 통해 BoardDto 객체를 생성 후 반환
     */

    public BoardDto(HttpServletRequest request) throws ParseException {
        this.writer = request.getParameter("writer");
        this.title = request.getParameter("title");
        this.content = request.getParameter("content");
        if(request.getParameter("imgRoute")!= null) this.imgRoute = request.getParameter("imgRoute");
    }

    /**
     * http 요청으로 받은 값의 파라미터를 통해 MemberDto 객체를 생성 후 반환
     * 기본키로 자동생성되는 NO
     * 값이 자동으로 삽입되는 writeDate
     * default 값이 0인 order, view, recommend
     *
     */

    public Board toEntity(){
        return Board.builder()
                .no(no)
                .writer(writer)
                .title(title)
                .content(content)
                .writeDate(writeDate)
                .isDelete(isDelete)
                .view(view)
                .recommend(recommend)
                .imgRoute(imgRoute)
                .build();
    }
    /**
     * BoardDto 값을 Board로 변환
     */

}
