package com.sks.boardserver.board.data;

import com.sks.boardserver.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int no;
    private String writer;
    private String title;
    private String content;
    private Date writeDate;
    private int seq;
    private boolean isDelete;
    private int view;
    private int recommend;
    private int parentNo;
    private String imgRoute;
    /**
     * Board entity 값을 통해 BoardDto 객체를 생성 후 반환
     */
    public BoardDto(Board board){
        this.no = board.getNo();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writeDate = board.getWriteDate();
        this.seq = board.getSeq();
        this.isDelete = board.isDelete(); // boolean 타입은 롬복 사용시 isXXX 형태로 생성
        this.view = board.getView();
        this.recommend = board.getRecommend();
        this.parentNo = board.getParentNo();
        this.imgRoute = board.getImgRoute();
    }

    /**
     * http 요청으로 받은 값의 파라미터를 통해 MemberDto 객체를 생성 후 반환
     */
    public BoardDto(HttpServletRequest request) throws ParseException {
        System.out.println(request.getParameter("no"));
        this.no = Integer.parseInt(request.getParameter("no"));
        this.writer = request.getParameter("writer");
        this.title = request.getParameter("title");
        this.content = request.getParameter("content");
        this.writeDate = stringToDate(request.getParameter("writeDate"));
        this.seq = Integer.parseInt(request.getParameter("seq"));
        this.isDelete = Boolean.parseBoolean(request.getParameter("isDelete")); // boolean 타입은 롬복 사용시 isXXX 형태로 생성
        this.view = Integer.parseInt(request.getParameter("view"));
        this.recommend = Integer.parseInt(request.getParameter("recommend"));
        this.parentNo = Integer.parseInt(request.getParameter("parentNo"));
        this.imgRoute = request.getParameter("imgRoute");
    }

    public Board toEntity(){
        return Board.builder()
                .no(no)
                .writer(writer)
                .title(title)
                .content(content)
                .writeDate(writeDate)
                .seq(seq)
                .isDelete(isDelete)
                .view(view)
                .recommend(recommend)
                .parentNo(parentNo)
                .imgRoute(imgRoute)
                .build();
    }
    /**
     * 문자열 타입의 날짜 값을 Date 객체 값으로 생성하여 반환
     * <p>형식 : yyyy-MM-dd (형식을 맞추지 않으면 ParseException 발생 할 수도 있음)</p>
     */
    private Date stringToDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);
        return format.parse(value);
    }

}
