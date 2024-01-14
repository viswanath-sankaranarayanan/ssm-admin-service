package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;

@Entity
public class MenuDetail extends SuperEntity {

    @Id
    @SequenceGenerator(sequenceName = "menu_detail_id_seq", name = "menuDetailIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuDetailIdSeq")
    private Long menuId;
    private String menuName;

}
