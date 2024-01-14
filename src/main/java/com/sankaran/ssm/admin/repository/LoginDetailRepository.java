package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LoginDetailRepository extends JpaRepository<LoginDetail, Long> {

    Optional<LoginDetail> findByLoginUserIdAndIsActiveIsTrue(String loginUserId);

    Optional<LoginDetail> findByLoginUserIdAndLoginPasswordAndIsActiveIsTrue(String loginUserId, String loginPassword);

    List<LoginDetail> findAllByIsActiveIsTrue();

    @Query(nativeQuery = true,
    value = "select (case when ld.roll_id = 3 then " +
            "(select COALESCE(student_first_name,'') || ' ' || COALESCE(student_middle_name,'') || ' ' || " +
            "COALESCE(student_last_name,'') from ssm.student_information where student_info_id = ld.user_id) else " +
            "(select COALESCE(staff_first_name,'') || ' ' || COALESCE(staff_middle_name,'') || ' ' || " +
            "COALESCE(staff_last_name,'') from ssm.staff_information where staff_info_id = ld.user_id) end) as userName " +
            "from ssm.login_detail ld where ld.user_id = :userId")
    String getLoggedInUserName(Long userId);
}
