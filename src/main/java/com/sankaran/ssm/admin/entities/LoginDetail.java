package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDetail extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "login_detail_id_seq", name = "loginDetailIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loginDetailIdSeq")
    private Long loginDetailId;
    private String loginUserId;
    private Long userId;
    private String loginPassword;
    private Long rollId;

    @OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private StaffInformation staffInformation;

    @OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private StudentInformation studentInformation;
}
