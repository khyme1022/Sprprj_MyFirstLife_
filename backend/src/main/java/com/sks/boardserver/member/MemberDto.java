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
        this.email = validateValue(request.getParameter("email"), 255);
        this.pwd = validateValue(request.getParameter("pwd"), 255);
        this.name = validateValue(request.getParameter("name"), 30);
        this.introduce = validateValue(request.getParameter("introduce"), 255);
        this.birth = defaultDate(request.getParameter("birth"));
        this.gender = defaultGender(request.getParameter("gender"));
        this.openPostInfo =defaultOpenPostInfo(request.getParameter("openPostInfo"));
    }

    /**
     * Member entity 값을 통해 MemberDto 객체를 생성 후 반환
     */
    public MemberDto(Member entity){
        this.email = entity.getEmail();
        this.pwd = entity.getPwd();
        this.name = entity.getName();
        this.introduce = entity.getIntroduce();
        this.birth = entity.getBirthDate();
        this.gender = entity.isGender() ? Gender.MALE : Gender.FEMALE;
        this.openPostInfo = entity.isOpenPostInfo();
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
                .birthDate(this.birth)
                .gender(this.gender.toBoolean())
                .openPostInfo(this.openPostInfo)
                .build();
    }

    /**
     * 문자열 타입의 value 값을 {@link Date} 타입으로 리턴한다.
     * <p>value 값이 공백이면 객체의 birth 값을 리턴한다.</p>
     */
    private Date defaultDate(String value) throws ParseException {
        return StringUtils.isBlank(value) ? this.birth : stringToDate(value);
    }

    /**
     * 문자열 타입의 날짜 값을 Date 객체 값으로 생성하여 반환
     * <p>형식 : yyyy-MM-dd (형식을 맞추지 않으면 ParseException 발생 할 수도 있음)</p>
     */
    private Date stringToDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);
        return format.parse(value);
    }

    /**
     * 문자열 타입의 value 값을 {@link Gender} 타입으로 리턴한다.
     */
    private Gender stringToGender(String value){
        return StringUtils.equals(value, "M") ? Gender.MALE : Gender.FEMALE;
    }

    /**
     * 문자열 타입의 value 값을 {@link Gender} 타입으로 리턴한다.
     * <p>value 값이 공백 값이면 객체의 gender 값을 리턴한다.</p>
     */
    private Gender defaultGender(String value){
        return StringUtils.isBlank(value) ? this.gender : stringToGender(value);
    }

    /**
     * 문자열 타입의 value 값을 boolean 타입으로 리턴한다.
     * <p>value 값이 공백 값이면 객체의 openPostInfo 값을 리턴한다.</p>
     */
    private boolean defaultOpenPostInfo(String value) {
        return StringUtils.isBlank(value) ? this.openPostInfo : BooleanUtils.toBoolean(value);
    }

    /**
     * 문자열 타입의 value 값이 유효한 값인지 확인한다.
     * <p>value 값의 길이가 limit 값을 넘으면 exception을 발생시킨다.</p>
     */
    private String validateValue(String value, int limit){
        if(value != null && value.length() > limit){
            throw new IllegalArgumentException();
        }
        return value;
    }

    /**
     * 해당 객체의 특정 값을 수정한다.
     * <ul>
     *     <li>pwd</li>
     *     <li>introduce</li>
     *     <li>birth</li>
     *     <li>gender</li>
     *     <li>openPostInfo</li>
     * </ul>
     */
    public void modify(HttpServletRequest request) throws ParseException {
        this.pwd = StringUtils.defaultString(validateValue(request.getParameter("pwd"), 30), this.pwd);
        this.introduce = StringUtils.defaultString(validateValue(request.getParameter("introduce"), 255), this.introduce);
        this.birth = defaultDate(request.getParameter("birth"));
        this.gender = defaultGender(request.getParameter("gender"));
        this.openPostInfo = defaultOpenPostInfo(request.getParameter("openPostInfo"));
    }
}
