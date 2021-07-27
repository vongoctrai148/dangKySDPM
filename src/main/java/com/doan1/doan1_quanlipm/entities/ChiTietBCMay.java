package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chitietbcmay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietBCMay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ttdkid")
    private ThongTinDKGV thongTinDKGV;
    @ManyToOne
    @JoinColumn(name = "mamay")
    private MayTinh mayTinh;
    private String noidungbc;
    private Date ngaybc;
    private int tinhtrang;

    public ChiTietBCMay(ThongTinDKGV thongTinDKGV, MayTinh mayTinh, String noidungbc, Date ngaybc, int tinhtrang) {
        this.thongTinDKGV = thongTinDKGV;
        this.mayTinh = mayTinh;
        this.noidungbc = noidungbc;
        this.ngaybc = ngaybc;
        this.tinhtrang = tinhtrang;
    }
}
