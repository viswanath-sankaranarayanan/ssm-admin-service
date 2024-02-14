package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.MenuDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDetailRepository extends JpaRepository<MenuDetail, Long> {

    List<MenuDetail> findAllByIsActiveIsTrue();

    @Query(value = "select md from MenuDetail md inner join MenuRoleMapping mrm on mrm.menuId = md.menuId and mrm.roleId = :rollId")
    List<MenuDetail> findByRoleId(Long rollId);

    @Query(value = "select md from MenuDetail md where (upper(md.menuName) like %:filterValue% " +
            "or upper(md.contentName) like %:filterValue% or cast(md.menuId as string ) like %:filterValue%) " +
            "and md.isActive = true ")
    List<MenuDetail> filterMenuDetail(String filterValue);
}
