package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HolidayRepository extends JpaRepository<Holidays, Long> {

    List<Holidays> findByHolidayYearOrderByHolidayDate(String holidayYear);

}
