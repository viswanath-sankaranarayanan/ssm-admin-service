package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuRoleMappingDto extends SuperDto{

    private Long menuRoleMapId;
    private MenuDetailDto menuDetail;
    private RoleDetailDto roleDetail;
}
