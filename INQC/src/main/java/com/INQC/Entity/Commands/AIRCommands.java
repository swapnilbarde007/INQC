package com.INQC.Entity.Commands;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "aircommands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AIRCommands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "airCommands")
    @JsonManagedReference
    List<Method> methodList;
}
