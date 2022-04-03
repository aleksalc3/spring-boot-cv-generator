package com.aleksa.springbootcvgenerator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "obtains")
public class Obtain {
    @EmbeddedId
    private CVTemplateSectionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("templateId")
    @JoinColumn(name = "template_id")
    private CVTemplate cvTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sectionId")
    @JoinColumn(name = "section_id")
    private Section section;

    @Column(name = "orderOfSections")
    private Integer orderOfSections;

    @Column(name = "repeatOfSections")
    private boolean repeatOfSections;

    public Obtain() {}
    public Obtain(CVTemplate cvTemplate, Section section) {
        this.cvTemplate = cvTemplate;
        this.section = section;
    }

}
