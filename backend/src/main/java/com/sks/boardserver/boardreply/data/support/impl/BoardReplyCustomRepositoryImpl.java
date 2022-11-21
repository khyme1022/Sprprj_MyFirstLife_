package com.sks.boardserver.boardreply.data.support.impl;

import com.sks.boardserver.boardreply.data.support.BoardReplyCustomRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import com.sks.boardserver.boardreply.entity.QBoardReply;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

/**
 * BoardReply 커스텀 리포지토리
 */
@Component
public class BoardReplyCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardReplyCustomRepository {
    public BoardReplyCustomRepositoryImpl() {
        super(BoardReply.class);
    }


    @Override
    public void updateByReplyNo(int replyNo, String content) {
        QBoardReply qBoardReply = QBoardReply.boardReply;
        update(qBoardReply)
                .set(qBoardReply.content, content)
                .where(qBoardReply.replyNo.eq(replyNo))
                .execute();

    }

    @Override
    public void deleteByReplyNo(int replyNo) {
        QBoardReply qBoardReply = QBoardReply.boardReply;
        update(qBoardReply)
                .set(qBoardReply.isDelete,true)
                .where(qBoardReply.replyNo.eq(replyNo))
                .execute();
    }
}
