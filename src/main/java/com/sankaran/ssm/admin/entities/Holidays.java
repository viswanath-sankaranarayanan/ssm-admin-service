package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Holidays extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "holiday_id_seq", name = "holidayIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holidayIdSeq")
    private Long holidayId;
    private String holidayYear;
    private LocalDate holidayDate;
    @OneToOne
    @JoinColumn(name = "holiday_type")
    private CodeMaster holidayType;
}
