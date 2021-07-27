package com.doan1.doan1_quanlipm.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "danhsachdksv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhSachDKSV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stt;
    private String madk;
}
