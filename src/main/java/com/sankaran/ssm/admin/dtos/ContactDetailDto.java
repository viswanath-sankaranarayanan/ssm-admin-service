package com.sankaran.ssm.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailDto extends SuperDto{

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
