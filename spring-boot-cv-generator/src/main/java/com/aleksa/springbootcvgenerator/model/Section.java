package com.aleksa.springbootcvgenerator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private List<Field> fields;

    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Obtain> obtains;
    public Section(){

    }

    public void addObtain(Obtain o){
        this.obtains.add(o);
    }
}
