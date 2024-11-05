package com.INQC.DTO.UCIP_LIB.Builder;

import com.INQC.DTO.UCIP_CORE.Member;
import com.INQC.DTO.UCIP_CORE.Struct;

import java.util.ArrayList;
import java.util.List;

public class StructBuilder {
    private List<Member> members = new ArrayList<>();

    public StructBuilder addMember(Member member) {
        members.add(member);
        return this;
    }

    public Struct build() {
        Struct struct = new Struct();
        struct.setMembers(members);
        return struct;
    }
}
