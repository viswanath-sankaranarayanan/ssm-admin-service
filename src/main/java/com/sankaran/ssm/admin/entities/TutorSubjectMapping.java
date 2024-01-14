package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TutorSubjectMapping {

    @Id
    @SequenceGenerator(sequenceName = "ts_mapping_id_seq", name = "tsMappingIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tsMappingIdSeq")
    private Long tsMappingId;
    private Long tutorId;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private CodeMaster subjectCode;
    private Boolean isMaster;
}
