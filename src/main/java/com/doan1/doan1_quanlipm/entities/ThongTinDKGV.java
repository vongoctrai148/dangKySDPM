package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "thongtindkgv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinDKGV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "maphong")
    private PhongMay phongmay;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "malhp")
    private LopHocPhan lophp;

    @JsonIgnore
    @OneToMany(mappedBy = "thongtindkgv", fetch = FetchType.LAZY)
    private List<ThongTinDangKyPhanMem> thongtindangkyphanmems;

    @JsonIgnore
    @OneToMany(mappedBy =  "thongTinDKGV", fetch = FetchType.LAZY)
    private List<ChiTietBCMay> chiTietBCMays;

    private Date thoigiandk;
    private Date ngaysd;
    private String giobatdau;
    private String gioketthuc;
    private String mucdich;
    private int soluongsv;
    private int ketqua;

    public ThongTinDKGV(Users user, PhongMay phongmay, LopHocPhan lophp, Date thoigiandk, Date ngaysd, String giobatdau, String gioketthuc, String mucdich, int soluongsv, int ketqua) {
        this.user = user;
        this.phongmay = phongmay;
        this.lophp = lophp;
        this.thoigiandk = thoigiandk;
        this.ngaysd = ngaysd;
        this.giobatdau = giobatdau;
        this.gioketthuc = gioketthuc;
        this.mucdich = mucdich;
        this.soluongsv = soluongsv;
        this.ketqua = ketqua;
    }
}
