package com.doan1.doan1_quanlipm.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lophocphan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LopHocPhan {
    @Id
    private String malhp;
    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;
    private String madssv;
    private String tenlhp;
    @OneToMany(mappedBy = "lophp", fetch = FetchType.LAZY)
    private List<ThongTinDKGV> thongTinDKGV;

}
