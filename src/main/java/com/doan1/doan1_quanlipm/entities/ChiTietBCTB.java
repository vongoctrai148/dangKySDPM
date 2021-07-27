package com.doan1.doan1_quanlipm.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "chitietbctb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietBCTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int bcid;
    private String matb;
    private String noidungbc;
    private String tinhtrang;

}
