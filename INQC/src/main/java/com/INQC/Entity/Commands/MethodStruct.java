package com.INQC.Entity.Commands;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "method_struct")
@Document(collection = "method_struct")
public class MethodStruct {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

//    @Column
    String memberName;


//    @Column
    String memberValue;

//    @Column
    String memberDataType;

//    @Column
    List<String> possibleValues=new ArrayList<>();

//    @Column
    char allowedNulls;

//    @Column
    char mandatoryInput;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "methodStruct")
//    @JsonManagedReference
    List<MethodStruct> methodStructList=new ArrayList<>();

    //List<List<MethodStruct>> nestedMethodStructList= new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name = "method_struct_id")
//    @JsonBackReference
//    MethodStruct methodStruct;

    //Done
//    @ManyToOne
//    @JoinColumn(name = "method_id")
//    @JsonBackReference
//    Method method;

//    public void addMethodStructInternal(MethodStruct methodStruct) {
//        methodStructList.add(methodStruct);
//       methodStruct.setMethodStruct(this);// Set the bidirectional reference
//    }

}
