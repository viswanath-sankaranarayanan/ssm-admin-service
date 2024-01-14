package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.StaffInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface StaffInformationRepository extends JpaRepository<StaffInformation, Long> {

    @Query(value = "select si from StaffInformation si where si.staffTypeCode.codeValue='TUT'")
    List<StaffInformation> getTutorList();

    @Query(value = "select si from StaffInformation si where si.isActive=true ")
    List<StaffInformation> findAllActive();

    Optional<StaffInformation> findFirstByIsActiveIsTrueOrderByStaffInfoIdDesc();
}
