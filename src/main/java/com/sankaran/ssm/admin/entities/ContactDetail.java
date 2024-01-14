package com.sankaran.ssm.admin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetail extends SuperEntity{

    @Id
    @SequenceGenerator(sequenceName = "contact_detail_id_seq", name = "contactDetailIdSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactDetailIdSeq")
    private Long contactDetailId;
    private String address1;
    private String address2;
    private String city;
    private String stateCode;
    private String countryCode;
    private String phoneNumber;
    private String altPhoneNumber;
    private String emailId;

}
