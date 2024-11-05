package com.INQC.DTO.UCIP_CORE;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Array {
    @XmlElement(name = "data")
    List<Data> data;
}
