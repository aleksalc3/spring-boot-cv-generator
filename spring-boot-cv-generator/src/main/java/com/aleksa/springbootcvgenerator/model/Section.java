package com.aleksa.springbootcvgenerator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "sections")
public class Section implements Comparable<Section>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "repeatable", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean repeatable;





    @Column(name = "repeatableTitle", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean repeatableTitle;


    @Column(name = "template_id", nullable = false)
    private Long templateId;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private List<Field> fields;


    @Override
    public int compareTo(Section o) {
        return (int) (this.id-o.id);
    }
}
