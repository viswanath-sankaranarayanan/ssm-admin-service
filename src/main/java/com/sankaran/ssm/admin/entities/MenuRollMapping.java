package com.sankaran.ssm.admin.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class MenuRollMapping extends SuperEntity{

    private Long menuRollMapId;
    private Long menuId;
    private Long rollId;

    @JoinColumn(name = "menuId", updatable = false, insertable = false)
    @OneToOne
    private MenuDetail menuDetail;

    @JoinColumn(name = "rollId", updatable = false, insertable = false)
    @OneToOne
    private RollDetail rollDetail;
}
