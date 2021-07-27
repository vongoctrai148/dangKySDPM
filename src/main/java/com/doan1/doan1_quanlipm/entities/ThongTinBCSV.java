package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "thongtinbaocaosv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinBCSV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ttdkid")
    private ThongTinDKSV thongTinDKSV;
    private String tinhtrang;
    private Date ngaybc;
    private int tinhtrangxl;

    public ThongTinBCSV(ThongTinDKSV thongTinDKSV, String tinhtrang, Date ngaybc, int tinhtrangxl) {
        this.thongTinDKSV = thongTinDKSV;
        this.tinhtrang = tinhtrang;
        this.ngaybc = ngaybc;
        this.tinhtrangxl = tinhtrangxl;
    }
}
