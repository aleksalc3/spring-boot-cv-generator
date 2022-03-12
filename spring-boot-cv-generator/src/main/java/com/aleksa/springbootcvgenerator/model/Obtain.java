package com.aleksa.springbootcvgenerator.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "obtains")
public class Obtain {
    @EmbeddedId
    private CVTemplateSectionKey id;

    @ManyToOne
    @MapsId("templateId")
    @JoinColumn(name = "template_id")
    private CVTemplate cvTemplate;

    @ManyToOne
    @MapsId("sectionId")
    @JoinColumn(name = "section_id")
    private Section section;

    @Column(name = "orderOfSections")
    private Integer orderOfSections;

    @Column(name = "repeatOfSections")
    private boolean repeatOfSections;
}
