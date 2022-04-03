package com.aleksa.springbootcvgenerator.model;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Embeddable
public class CVTemplateSectionKey implements Serializable {

    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "section_id")
    private Long sectionId;

    public CVTemplateSectionKey(Long id, Long id1) {
        this.templateId=id;
        this.sectionId=id1;
    }

    public CVTemplateSectionKey() {

    }
}
