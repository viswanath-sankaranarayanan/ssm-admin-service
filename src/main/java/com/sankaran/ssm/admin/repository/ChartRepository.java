package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChartRepository extends JpaRepository<StudentAttendance, Long> {

    @Query(nativeQuery = true,
    value = "select case when is_present then 'Present' else 'Absent' end , count(*) from ssm.student_attendance \n" +
            "where to_char(attendance_date,'YYYY-MM-DD')='2023-10-03'\n" +
            "group by is_present order by is_present desc")
    List<Object[]> getStudentAttendanceCount(@Param("currentDate") String currentDate);

    @Query(nativeQuery = true,
    value = "select cm.code_value , cm.code_description , count(si.*)  from ssm.staff_information si left join ssm.code_master cm on cm.code_master_id = si.staff_type group by cm.code_value , cm.code_description")
    List<Object[]> getStaffCount();
}
