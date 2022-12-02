package com.sks.boardserver.board.data.support.impl;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.hibernate.HibernateUpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.sks.boardserver.board.data.support.BoardCustomRepository;
import com.sks.boardserver.board.entity.Board;
import com.sks.boardserver.board.entity.QBoard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;


// QueryDSL 메소드 정의 구현 클래스
@Component
public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository {

    public BoardCustomRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Board findByNo(int number) {
        System.out.print("findByNO : " + number);
        System.out.println();
        QBoard qBoard = QBoard.board;

        Board board = from(qBoard)
                .where(qBoard.no.eq(number))
                        .select(qBoard).fetchOne();
        System.out.println(board);
        return board;
    }

    public void updateByNo(String title, String content, int number){
        QBoard qBoard = QBoard.board;
        update(qBoard)
                .set(qBoard.title, title)
                .set(qBoard.content, content)
                .where(qBoard.no.eq(number))
                .execute();

    }

    @Override
    public void deleteByNo(int number) {
        QBoard qBoard = QBoard.board;
        update(qBoard)
                .set(qBoard.isDelete,true)
                .where(qBoard.no.eq(number))
                .execute();
    }

}
