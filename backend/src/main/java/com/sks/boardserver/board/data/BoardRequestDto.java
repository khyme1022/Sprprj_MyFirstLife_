package com.sks.boardserver.board.data;

import com.sks.boardserver.board.entity.Board;
import lombok.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {
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
     * DB 삽입 및 수정 메소드 사용 시 HTTP request를 BoardDto로 변환
     */
    public BoardRequestDto(HttpServletRequest request) throws ParseException {
        this.writer = request.getParameter("writer");
        this.title = request.getParameter("title");
        this.content = request.getParameter("content");
        if(request.getParameter("imgRoute")!= null) this.imgRoute = request.getParameter("imgRoute");
    }

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


}
