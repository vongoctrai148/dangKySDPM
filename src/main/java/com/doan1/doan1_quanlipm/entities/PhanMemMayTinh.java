package com.doan1.doan1_quanlipm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "phanmemmaytinh")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhanMemMayTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "mamay")
    private MayTinh maytinh;
    @ManyToOne
    @JoinColumn(name = "maphanmem")
    private PhanMem phanmem;

    @JsonBackReference
    public MayTinh getMaytinh() {
        return maytinh;
    }

    @JsonBackReference
    public PhanMem getPhanmem() {
        return phanmem;
    }
}
