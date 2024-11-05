package com.INQC.Entity.Commands;



import com.INQC.DTO.UCIP_CORE.MethodCall;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "method")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    @NotNull
    String  methodName;

    @ManyToOne
    @JoinColumn(name = "aircommands_id")
    @JsonBackReference
    AIRCommands airCommands;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "method")
    @JsonManagedReference
    List<MethodStruct> methodStructList;

}
