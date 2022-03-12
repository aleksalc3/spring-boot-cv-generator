package com.aleksa.springbootcvgenerator.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
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

    @ManyToMany
    @JoinTable(
            name = "tags_templates",
            joinColumns = @JoinColumn(name = "template_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @OneToMany(mappedBy = "cvTemplate")
    private List<Obtain> obtains;
}
