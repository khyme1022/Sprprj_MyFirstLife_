package com.sks.boardserver.boardreply.data.support.impl;

import com.sks.boardserver.boardreply.data.support.BoardReplyCustomRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardReplyCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardReplyCustomRepository {
    public BoardReplyCustomRepositoryImpl() {
        super(BoardReply.class);
    }
}
