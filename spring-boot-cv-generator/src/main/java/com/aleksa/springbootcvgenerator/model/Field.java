package com.aleksa.springbootcvgenerator.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "section_id", nullable = false)
    private Long sectionId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @Column(name = "description", nullable = false, length = 500)
    private String description;
}
