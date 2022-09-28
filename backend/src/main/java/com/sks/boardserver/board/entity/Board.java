package com.sks.boardserver.board.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BOARD")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Board{
    /** 글번호  
     * 기본키 자동생성 설정으로 1부터 생성됨*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO", nullable = false, updatable = false)
    private int no;

    /** 글 작성자  */
    @Column(name = "BOARD_WRITER", length = 30, nullable = false)
    private String writer;

    /** 글 제목  */
    @Column(name = "BOARD_TITLE", nullable = false) // 정해주지 않으면 기본 길이는 255
    private String title;

    /** 글 내용  */
    @Column(name = "BOARD_CONTENT", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @CreatedDate
    @Column(name = "BOARD_WRITE_DATE", columnDefinition = "DATETIME", nullable = false, updatable = false)
    private LocalDateTime writeDate;

    /** 글 삭제 여부 default = false */
    @Column(name = "BOARD_IS_DELETE", nullable = false, columnDefinition = "TINYINT(4) default 0")
    private boolean isDelete;

    /** 조회수 default : 0   */
    @Column(name = "BOARD_VIEW", nullable = false, columnDefinition = "Integer default 0")
    private int view;

    /** 추천 수 default = 0  */
    @Column(name = "BOARD_RECOMMEND", nullable = false, columnDefinition = "Integer default 0")
    private int recommend;

    /** 이미지 파일 루트  */
    @Column(name = "BOARD_IMG_ROUTE",columnDefinition ="LONGTEXT default NULL" )
    private String imgRoute;

    // 생각해보니 액자형 게시판을 만든다고 했는데 게시글에 답글 게시글 다는 건 쓸모가 없는 것 같아서 자식글 위한 컬럼들은 다 삭제함
}
