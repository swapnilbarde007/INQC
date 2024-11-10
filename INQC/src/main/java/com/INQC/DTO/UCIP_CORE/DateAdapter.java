package com.INQC.DTO.UCIP_CORE;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.Instant;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ssZ");

    @Override
    public Date unmarshal(String v) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(v, formatter);
        return Date.from(zonedDateTime.toInstant());
    }

    @Override
    public String marshal(Date v) {
        return formatter.format(v.toInstant().atZone(ZonedDateTime.now().getZone()));
    }
}
