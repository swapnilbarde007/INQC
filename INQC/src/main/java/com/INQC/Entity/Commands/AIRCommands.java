package com.INQC.Entity.Commands;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "aircommands")
@Document(collection = "aircommands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AIRCommands {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //long id;
    @Id
    String id;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "airCommands")
//    @JsonManagedReference
    List<Method> methodList=new ArrayList<>();

//    public void addMethod(Method method) {
//        methodList.add(method);
//        method.setAirCommands(this); // Set the bidirectional reference
//    }
}
