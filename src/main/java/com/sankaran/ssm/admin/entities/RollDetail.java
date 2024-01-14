package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;

@Entity
public class RollDetail extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "roll_detail_id_seq", name = "rollDetailIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rollDetailIdSeq")
    private Long rollId;
    private String rollName;
}
