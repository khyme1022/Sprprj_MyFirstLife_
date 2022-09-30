package com.sks.boardserver.boardreply.data.support.impl;

import com.sks.boardserver.board.entity.QBoard;
import com.sks.boardserver.boardreply.data.support.BoardReplyCustomRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import com.sks.boardserver.boardreply.entity.QBoardReply;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardReplyCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardReplyCustomRepository {
    public BoardReplyCustomRepositoryImpl() {
        super(BoardReply.class);
    }

    public void updateByNo(String content, int replyNum, int boardNum){
        QBoardReply qBoardReply = QBoardReply.boardReply;
        update(qBoardReply)
                .set(qBoardReply.content, content)
                .where(qBoardReply.replyNo.eq(replyNum),qBoardReply.boardNo.eq(boardNum))
                .execute();
    }

    public void deleteByNo(int replyNum, int boardNum){
        QBoardReply qBoardReply = QBoardReply.boardReply;
        update(qBoardReply)
                .set(qBoardReply.isDelete, true)
                .where(qBoardReply.replyNo.eq(replyNum),qBoardReply.boardNo.eq(boardNum))
                .execute();
    }
}
