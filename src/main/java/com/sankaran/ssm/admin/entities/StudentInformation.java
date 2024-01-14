package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInformation extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "student_info_id_seq", name = "studentInfoIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentInfoIdSeq")
    private Long studentInfoId;
    private String studentRollNumber;
    private String studentFirstName;
    private String studentMiddleName;
    private String studentLastName;
    private String gender;
    private String bloodGroup;
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personalInfoId")
    private PersonalInformation personalInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactDetailId")
    private ContactDetail contactDetail;
}
