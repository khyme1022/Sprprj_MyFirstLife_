package com.sks.boardserver.member;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

enum Gender {
    MALE(true),
    FEMALE(false);

    private boolean gender;

    Gender(boolean gender) {
        this.gender = gender;
    }

    public boolean toBoolean(){
        return this.gender;
    }

    public void setGender(boolean gender){
        this.gender = gender;
    }
}
public class MemberDto {
    @Getter
    @NotNull
    private String email;

    @Setter
    @NotNull
    private String pwd;

    @Getter
    @NotNull
    private String name;

    @Getter
    @Nullable
    private String introduce;

    @Getter
    @Setter
    @NotNull
    private Date birth;

    @Getter
    @Setter
    @NotNull
    private Gender gender;

    @Getter
    @Setter
    @NotNull
    private boolean openPostInfo;

    /**
     * http 요청으로 받은 값의 파라미터를 통해 MemberDto 객체를 생성 후 반환
     */
    public MemberDto(HttpServletRequest request) throws ParseException {
        this.email = request.getParameter("email");
        this.pwd = request.getParameter("pwd");
        this.name = request.getParameter("name");
        this.introduce = request.getParameter("introduce");
        this.birth = stringToDate(request.getParameter("birth"));
        this.gender = StringUtils.equals(request.getParameter("gender"), "M") ? Gender.MALE : Gender.FEMALE;
        this.openPostInfo = BooleanUtils.toBoolean(request.getParameter("openPostInfo"), "true", "fals");
    }

    /**
     * Member entity 값을 통해 MemberDto 객체를 생성 후 반환
     */
    public MemberDto(Member entity){
        this.email = entity.getEmail();
        this.pwd = entity.getPwd();
        this.name = entity.getName();
        this.introduce = entity.getIntroduce();
        this.birth = entity.getBirth();
        this.gender = entity.isGender() ? Gender.MALE : Gender.FEMALE;
        this.openPostInfo = entity.isOpenPostInfo();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * Member entity 객체 값으로 변환 후 반환
     */
    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .pwd(this.pwd)
                .name(this.name)
                .introduce(this.introduce)
                .birth(this.birth)
                .gender(this.gender.toBoolean())
                .openPostInfo(this.openPostInfo)
                .build();
    }

    /**
     * 문자열 타입의 날짜 값을 Date 객체 값으로 생성하여 반환
     * <p>형식 : yyyy-MM-dd (형식을 맞추지 않으면 ParseException 발생 할 수도 있음)</p>
     */
    private Date stringToDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);
        return format.parse(value);
    }
}
