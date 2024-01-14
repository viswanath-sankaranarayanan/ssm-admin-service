package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendance{
    @Id
    @SequenceGenerator(sequenceName = "st_attendance_id_seq" , name = "stAttendanceIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "stAttendanceIdSeq")
    private Long stAttendanceId;
    @OneToOne
    @JoinColumn(name = "studentId")
    private StudentInformation studentInformation;

    @OneToOne
    @JoinColumn(name = "tutorId")
    private StaffInformation staffInformation;

    private Boolean isPresent;
    private LocalDateTime attendanceDate;
}
