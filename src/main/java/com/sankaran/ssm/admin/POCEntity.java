package com.sankaran.ssm.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class POCEntity {

    @Id
    private Integer id;
    private String name;

}
