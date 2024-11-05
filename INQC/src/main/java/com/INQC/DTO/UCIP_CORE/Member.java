package com.INQC.DTO.UCIP_CORE;

import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Member {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "value")
    private MemberValue value;
}