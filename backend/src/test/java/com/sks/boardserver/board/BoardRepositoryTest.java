package com.sks.boardserver.board;

import com.sks.boardserver.board.data.BoardRepository;
import com.sks.boardserver.board.entity.Board;
import com.sks.boardserver.boardreply.data.BoardReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardReplyRepository boardReplyRepository;

    @Test
    void boardTest1(){
        Board board = new Board();
        board.setNo(1);
        board.setWriter("gw");
        board.setTitle("title");
        board.setContent("Content --- ---");
        board.setWriteDate(LocalDateTime.now());
        board.isDelete();
        board.setView(0);
        board.setRecommend(0);
        board.setImgRoute(null);
    }
}
