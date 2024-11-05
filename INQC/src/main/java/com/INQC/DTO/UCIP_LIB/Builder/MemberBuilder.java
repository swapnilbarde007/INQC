package com.INQC.DTO.UCIP_LIB.Builder;

import com.INQC.DTO.UCIP_CORE.Member;
import com.INQC.DTO.UCIP_CORE.MemberValue;

import java.util.Date;

public class MemberBuilder {

    private String name;
    private MemberValue value;


    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setStringValue(String value) {
        this.value = new MemberValue();
        this.value.setStringValue(value);
        return this;
    }

    public MemberBuilder setIntValue(int value) {
        this.value = new MemberValue();
        this.value.setIntValue(value);
        return this;
    }

    public MemberBuilder setDateTime(Date date) {
        this.value = new MemberValue();
        this.value.setDateTime(date);
        return this;
    }

    public Member build() {
        Member member = new Member();
        member.setName(name);
        member.setValue(value);
        return member;
    }

}
