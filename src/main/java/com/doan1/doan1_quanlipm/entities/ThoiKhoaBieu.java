package com.doan1.doan1_quanlipm.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "thoikhoabieu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThoiKhoaBieu {
    @Id
    private Long id;
    private int thu;
    private int tutiet;
    private int dentiet;
    private String maphong;
    private String giangvien;
    private int soluong;
}
