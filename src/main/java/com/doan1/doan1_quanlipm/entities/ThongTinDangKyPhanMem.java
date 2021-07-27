package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "thongtindangkyphanmem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinDangKyPhanMem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ttdkidsv")
    private ThongTinDKSV thongtindksv;

    @ManyToOne
    @JoinColumn(name = "ttdkidgv")
    private ThongTinDKGV thongtindkgv;

    @ManyToOne
    @JoinColumn(name = "maphanmem")
    private PhanMem phanmem;

    public ThongTinDangKyPhanMem(ThongTinDKSV thongtindksv, PhanMem phanmem) {
        this.thongtindksv = thongtindksv;
        this.phanmem = phanmem;
    }

    public ThongTinDangKyPhanMem(ThongTinDKGV thongtindkgv, PhanMem phanMem) {
        this.thongtindkgv = thongtindkgv;
        this.phanmem = phanMem;
    }
}
