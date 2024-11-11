package com.INQC.Entity.Commands;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "member_value_struct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberValueStruct {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int memberValueStructId;


    private String stringValue;


    private Integer intValue;


    private Date dateTime;


}
