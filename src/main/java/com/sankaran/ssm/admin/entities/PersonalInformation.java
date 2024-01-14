package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformation extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "personal_info_id_seq" , name = "personalInfoIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personalInfoIdSeq")
    private Long personalInfoId;
    private Long personTypeId;
    private String fatherFirstName;
    private String fatherMiddleName;
    private String fatherLastName;
    private String motherFirstName;
    private String motherMiddleName;
    private String motherLastName;
    private String gardianFirstName;
    private String gardianMiddleName;
    private String gardianLastName;
    private String gardianType;
}
