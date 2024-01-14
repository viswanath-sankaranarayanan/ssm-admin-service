package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.StudentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentInformationRepository extends JpaRepository<StudentInformation, Long> {

    @Query(value = "select s from StudentInformation s where s.isActive=true")
    List<StudentInformation> findAll();

    @Query(value = "select s from StudentInformation  s where (upper(s.studentFirstName) like %:filterValue% or " +
            "upper(s.studentMiddleName) like %:filterValue% or upper(s.studentLastName) like %:filterValue% or " +
            "upper(s.studentRollNumber) like %:filterValue% ) and s.isActive = true ")
    List<StudentInformation> findStudentInformationsByFilterValue(@Param(value = "filterValue") String filterValue);

    Optional<StudentInformation> findFirstByIsActiveIsTrueOrderByStudentInfoIdDesc();
}
