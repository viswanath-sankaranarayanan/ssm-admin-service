package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDetail extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "role_detail_id_seq", name = "roleDetailIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleDetailIdSeq")
    private Long roleId;
    private String roleName;
}
