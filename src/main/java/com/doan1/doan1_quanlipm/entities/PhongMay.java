package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phongmay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongMay {
    @Id
    private String maphong;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "username")
    private Users user;
    private String trangthai;
    private int slmaychieu;
    private int sldieuhoa;
    private int slquat;
    @JsonIgnore
    @OneToMany(mappedBy = "maphong", fetch = FetchType.LAZY)
    private List<ThongTinDKSV> thongTinDKSV;
    @JsonIgnore
    @OneToMany(mappedBy = "phongmay", fetch = FetchType.LAZY)
    private List<ThongTinDKGV> thongTinDKGV;
    @JsonIgnore
    @OneToMany(mappedBy = "phongmay", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MayTinh> mayTinhs;
}
