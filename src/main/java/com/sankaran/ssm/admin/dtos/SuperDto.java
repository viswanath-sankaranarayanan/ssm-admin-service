package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperDto {
    private String createdBy;
    private LocalDateTime createdDate;
    private String createdDateStr;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String modifiedDateStr;
    private Boolean isActive;
}
