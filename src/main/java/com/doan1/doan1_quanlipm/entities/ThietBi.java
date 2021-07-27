package com.doan1.doan1_quanlipm.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "thietbi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThietBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matb;
    private String tentb;
    private String chitiet;
}
