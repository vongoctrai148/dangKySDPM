package com.doan1.doan1_quanlipm.forms;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThemBCMayForm {
    private Long id;
    private ThongTinDKGV thongTinDKGV;
    private MayTinh mayTinh;
    private String noidungbc;
    private String tinhtrang;
}
