package com.INQC.DTO.UCIP_CORE;

import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class MemberValue {
    @XmlElement(name = "string")
    private String stringValue;

    @XmlElement(name = "int")
    private Integer intValue;

    @XmlElement(name = "dateTime.iso8601")
    private Date dateTime;

    @XmlElement(name = "array")
    private Array array;

    @XmlElement(name = "struct")
    private Struct struct;
}
