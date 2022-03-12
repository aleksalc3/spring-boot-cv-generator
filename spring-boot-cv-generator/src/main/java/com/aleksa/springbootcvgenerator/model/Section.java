package com.aleksa.springbootcvgenerator.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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

    @OneToMany(mappedBy = "section")
    private List<Obtain> obtains;

}
