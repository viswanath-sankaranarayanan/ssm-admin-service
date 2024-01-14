package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sankaran.ssm.admin.entities.CodeMaster;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudetnMappingDto extends SuperDto{
    private Long studentMappingId;
    private Long studentId;
    private String batchCode;
    private String sectionCode;
    private Long classRoomId;
    private Long tutorId;
    private Boolean isClassTutor;
    private String subjectCode;
    private Integer batchYear;
}
