package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRoleMapping extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "menu_role_map_id_seq", name = "menuRoleMapIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuRoleMapIdSeq")
    private Long menuRoleMapId;
    private Long menuId;
    private Long roleId;

    @JoinColumn(name = "menuId", updatable = false, insertable = false)
    @OneToOne
    private MenuDetail menuDetail;

    @JoinColumn(name = "roleId", updatable = false, insertable = false)
    @OneToOne
    private RoleDetail roleDetail;
}
