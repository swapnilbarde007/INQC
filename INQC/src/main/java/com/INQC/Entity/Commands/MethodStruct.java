package com.INQC.Entity.Commands;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "method_struct")
public class MethodStruct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String memberName;


    @Column
    String memberValue;

    @Column
    String memberDataType;

    @Column
    List<String> possibleValues;

    @Column
    char allowedNulls;

    @Column
    char mandatoryInput;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "methodStruct")
    List<MethodStruct> methodStructList;

    @ManyToOne
    @JoinColumn(name = "method_struct_id")
    MethodStruct methodStruct;

    //Done
    @ManyToOne
    @JoinColumn(name = "method_id")
    @JsonBackReference
    Method method;

}
