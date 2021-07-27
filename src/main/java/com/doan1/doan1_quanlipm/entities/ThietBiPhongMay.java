package com.doan1.doan1_quanlipm.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "thietbiphongmay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThietBiPhongMay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maphong;
    private String matb;

}
