package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String username;
    private String passwords;
    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String quequan;
    private String roles;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ThongTinDKSV> thongTinDKSVs;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ThongTinDKGV> thongTinDKGVs;
    @JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private PhongMay phongMay;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LopHocPhan> lopHocPhans;
}
