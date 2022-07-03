package com.aleksa.springbootcvgenerator.model;


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
    private Long id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 500)
    private String description;

    @Column(name = "date_of_creation", nullable = false)
    private LocalDate dateOfCreation;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private List<Section> sections;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_model_id", referencedColumnName = "id")
    private ImageModel imageModel;

    public CVTemplate(){

    }


}
