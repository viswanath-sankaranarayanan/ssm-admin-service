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
public class TutorSubjectMappingDto extends SuperDto{
    private Long tsMappingId;
    private Long tutorId;
    private String subjectCode;
    private Boolean isMaster;
}
