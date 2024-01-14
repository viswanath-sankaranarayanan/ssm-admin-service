package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInformation extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "staff_info_id_seq", name = "staffInfoIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staffInfoIdSeq")
    private Long staffInfoId;
    private String staffId;
    private String staffFirstName;
    private String staffMiddleName;
    private String staffLastName;
    private String staffPhoneNumber;
    private String staffEmailId;
    private LocalDate dob;
    private String gender;
    private String bloodGroup;
    private Long staffType;

    @OneToOne
    @JoinColumn(name = "staffType", insertable = false, updatable = false)
    private CodeMaster staffTypeCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personalInfoId")
    private PersonalInformation personalInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactDetailId")
    private ContactDetail contactDetail;

}
