package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "maytinh")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MayTinh {
    @Id
    private String mamay;
    @ManyToOne
    @JoinColumn(name = "maphong")
    private PhongMay phongmay;
    private String tinhtrang;
    private String chitiet;
    @JsonIgnore
    @OneToMany(mappedBy = "mamay", fetch = FetchType.LAZY)
    private List<ThongTinDKSV> thongTinDKSVs;
    @JsonBackReference
    @OneToMany(mappedBy = "maytinh", fetch = FetchType.LAZY)
    private List<PhanMemMayTinh> phanMemMayTinhs;

    @JsonIgnore
    @OneToMany(mappedBy = "mayTinh", fetch = FetchType.LAZY)
    public List<ChiTietBCMay> chiTietBCMays;

    @JsonBackReference
    public PhongMay getPhongmay() {
        return phongmay;
    }

    @JsonManagedReference
    public List<PhanMemMayTinh> getPhanMemMayTinhs() {
        return phanMemMayTinhs;
    }
    @JsonBackReference
    public void setPhanMemMayTinhs(List<PhanMemMayTinh> phanMemMayTinhs) {
        this.phanMemMayTinhs = phanMemMayTinhs;
    }
}
