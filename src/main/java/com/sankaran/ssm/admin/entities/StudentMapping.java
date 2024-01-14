package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentMapping extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "student_mapping_id_seq", name = "studentMappingIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentMappingIdSeq")
    private Long studentMappingId;
    private Long studentId;
    @OneToOne
    @JoinColumn(name = "batch_id")
    private CodeMaster batchCode;
    @OneToOne
    @JoinColumn(name = "section_id")
    private CodeMaster sectionCode;
    private Long classRoomId;
    private Long tutorId;
    private Boolean isClassTutor;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private CodeMaster subjectCode;
    private Integer batchYear;

}
