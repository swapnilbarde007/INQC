package com.INQC.DTO.UCIP_CORE;


import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "methodResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class MethodResponse {

    @XmlElement(name = "params")
    private Params params;
}