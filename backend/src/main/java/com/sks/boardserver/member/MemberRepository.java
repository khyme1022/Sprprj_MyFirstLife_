package com.sks.boardserver.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    /**
     * email 값으로 DB에서 회원 정보를 가져와 반환
     */
    @Query(value = "SELECT m FROM MEMBER m WHERE m.email = :email")
    Member findMemberByEmail(@Param("email") String email);

    @Modifying
    @Query(value = "UPDATE MEMBER m SET m.deleteDate = :deleteDate WHERE m.id = :id")
    void updateMemberDeleteDate(@Param("id") int id, @Param("deleteDate") Date deleteDate);

    @Modifying
    @Query(value = "UPDATE MEMBER m SET m.pwd = :pwd, m.introduce = :introduce, m.birthDate = :birthDate, m.gender = :gender, m.openPostInfo = :openPostInfo WHERE m.id = :id")
    void updateMemberInfo(@Param("id") int id, @Param("pwd") String pwd, @Param("introduce") String introduce, @Param("birthDate") Date birthDate, @Param("gender") boolean gender, @Param("openPostInfo") boolean openPostInfo);
}
