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
public class MenuDetailDto extends SuperDto{

    private Long menuId;
    private String menuName;
    private String contentName;
    private Boolean menuSelected;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuDetailDto){
            MenuDetailDto menuDetailDto = (MenuDetailDto) obj;
            return this.menuId.equals(menuDetailDto.getMenuId());
        }else {
            return false;
        }
    }
}
