package com.sks.boardserver.board;

import com.querydsl.jpa.impl.JPAQuery;
import com.sks.boardserver.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class boardRepositoryTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void queryDslTest(){
        JPAQuery<Board> query = new JPAQuery(entityManager);
        QBoard qBoard= QBoard.board;

        List<Board> boardList = query
                .from(qBoard)
                .where(qBoard.no.eq(1))
                .orderBy(qBoard.no.asc())
                .fetch();

        for(Board board : boardList){
            System.out.println("--------");
            System.out.println("Board No : " + board.getNo());
            System.out.println("--------");
        }
    }
}
