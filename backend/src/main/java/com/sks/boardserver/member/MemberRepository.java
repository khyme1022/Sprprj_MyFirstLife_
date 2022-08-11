package com.sks.boardserver.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    /**
     * email 값으로 DB에서 회원 정보를 가져와 반환
     */
    @Query(value = "SELECT m FROM MEMBER m WHERE m.email = :email")
    Member findMemberByEmail(@Param("email") String email);
}
