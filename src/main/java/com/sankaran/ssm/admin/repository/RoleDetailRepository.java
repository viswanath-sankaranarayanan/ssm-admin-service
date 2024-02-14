package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.RoleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDetailRepository extends JpaRepository<RoleDetail, Long> {

    List<RoleDetail> findByIsActiveIsTrue();

    @Query(value = "select rd from RoleDetail rd where rd.isActive = true and " +
            "(upper(rd.roleName) like %:filterValue% or cast(rd.roleId as string ) like %:filterValue%)")
    List<RoleDetail> filterRoleDetail(String filterValue);
}
