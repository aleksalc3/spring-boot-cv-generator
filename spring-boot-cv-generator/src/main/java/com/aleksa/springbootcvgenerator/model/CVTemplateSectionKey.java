package com.aleksa.springbootcvgenerator.model;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class CVTemplateSectionKey implements Serializable {
    private static final long serialVersionUID = -2638656819324466864L;
    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "section_id")
    private Long sectionId;
}
