package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

}
