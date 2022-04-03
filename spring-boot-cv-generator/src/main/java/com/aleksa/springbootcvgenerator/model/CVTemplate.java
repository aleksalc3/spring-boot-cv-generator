package com.aleksa.springbootcvgenerator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "templates")
public class CVTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 500)
    private String description;

    @Column(name = "date_of_creation", nullable = false)
    private LocalDate dateOfCreation;

    @OneToMany(mappedBy = "cvTemplate",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Obtain> obtains;

    public CVTemplate(){

    }

    public void addObtain(Obtain o){
        this.obtains.add(o);
    }

}
