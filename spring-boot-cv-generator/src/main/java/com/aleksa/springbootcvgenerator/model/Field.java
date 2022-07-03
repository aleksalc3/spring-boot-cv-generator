package com.aleksa.springbootcvgenerator.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "fields")
public class Field implements Comparable<Field>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "section_id", nullable = false)
    private Long sectionId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Override
    public int compareTo(Field o) {
        return (int) (this.Id-o.Id);
    }
}
