package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "thongtindksv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinDKSV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "maphong")
    private PhongMay maphong;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mamay")
    private MayTinh mamay;
    private Date thoigiandk;
    private Date ngaysd;
    private String giobatdau;
    private String gioketthuc;
    private int ketqua;
    @JsonIgnore
    @OneToOne(mappedBy = "thongTinDKSV", fetch = FetchType.EAGER)
    private ThongTinBCSV thongTinBCSV;

    @JsonIgnore
    @OneToMany(mappedBy = "thongtindksv", fetch = FetchType.LAZY)
    private List<ThongTinDangKyPhanMem> thongTinDangKyPhanMems;

    public ThongTinDKSV(Users user, PhongMay maphong, MayTinh mamay, Date thoigiandk, Date ngaysd, String giobatdau, String gioketthuc, int ketqua) {
        this.user = user;
        this.maphong = maphong;
        this.mamay = mamay;
        this.thoigiandk = thoigiandk;
        this.ngaysd = ngaysd;
        this.giobatdau = giobatdau;
        this.gioketthuc = gioketthuc;
        this.ketqua = ketqua;
    }
}
