package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "codeMasterDetails", query = "select cm.code_master_id \"codeMasterId\" , " +
        "cm.code_value \"codeValue\", cm.code_description \"codeDescription\", cm.code_type \"codeType\" " +
        "from ssm.code_master cm where \n" +
        "(:codeValue is null or cm.code_value = :codeValue) \n" +
        "and (:codeDescription is null or cm.code_description = :codeDescription)\n" +
        "and (:codeType is null or cm.code_type = :codeType)", resultSetMapping = "codeMasterTransformer")
@SqlResultSetMapping(name = "codeMasterTransformer", classes = @ConstructorResult(targetClass = CodeMaster.class,
columns = {
@ColumnResult(name = "codeMasterId"), @ColumnResult(name = "codeValue"), @ColumnResult(name = "codeDescription"),
        @ColumnResult(name = "codeType")
}))
@Builder(toBuilder = true)
public class CodeMaster extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "code_master_id_seq", name = "codeMasterIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codeMasterIdSeq")
    private Long codeMasterId;
    private String codeValue;
    private String codeDescription;
    private String codeType;

}
