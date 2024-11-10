package com.INQC.Entity.Commands;



import com.INQC.DTO.UCIP_CORE.MethodCall;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "method")
@Document(collection = "method")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Method {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;

    @Id
    String id;

//    @Column
    String  methodName;
//
//    @Column
    String templateName;

//    @Column
    String templateDes;

//    @ManyToOne
//    @JoinColumn(name = "aircommands_id")
//    @JsonBackReference
//    AIRCommands airCommands;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "method")
//    @JsonManagedReference
    List<MethodStruct> methodStructList=new ArrayList<>();

//    public void addMethodStruct(MethodStruct methodStruct) {
//        methodStructList.add(methodStruct);
//        methodStruct.setMethod(this); // Set the bidirectional reference
//    }



}
