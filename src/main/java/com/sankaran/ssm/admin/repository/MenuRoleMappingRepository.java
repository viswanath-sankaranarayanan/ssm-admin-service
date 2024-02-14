package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.MenuRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRoleMappingRepository extends JpaRepository<MenuRoleMapping, Long> {

    List<MenuRoleMapping> findByRoleIdAndIsActiveIsTrue(Long roleId);

    MenuRoleMapping findByRoleIdAndMenuId(Long roleId, Long menuId);
}
