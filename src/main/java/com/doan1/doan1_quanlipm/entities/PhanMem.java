package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.awt.image.ImageProducer;
import java.util.List;

@Entity
@Table(name = "phanmem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhanMem {
    @Id
    private String maphanmem;
    private String tenphanmem;
    private String phienban;
    private String chitiet;
    @JsonIgnore
    @OneToMany(mappedBy = "phanmem", fetch = FetchType.LAZY)
    private List<PhanMemMayTinh> phanMemMayTinhs;

    @JsonIgnore
    @OneToMany(mappedBy = "phanmem", fetch = FetchType.LAZY)
    private List<ThongTinDangKyPhanMem> thongTinDangKyPhanMems;

    @JsonIgnore
    @JsonManagedReference
    public List<PhanMemMayTinh> getPhanMemMayTinhs() {
        return phanMemMayTinhs;
    }

    @JsonBackReference
    public void setPhanMemMayTinhs(List<PhanMemMayTinh> phanMemMayTinhs) {
        this.phanMemMayTinhs = phanMemMayTinhs;
    }
}
