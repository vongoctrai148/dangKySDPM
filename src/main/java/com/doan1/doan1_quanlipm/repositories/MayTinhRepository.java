package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MayTinhRepository extends JpaRepository<MayTinh, String> {
    @Query("select mt from MayTinh mt, PhongMay p " +
            "where p.maphong = mt.phongmay.maphong and p.maphong = ?1")
    List<MayTinh> getMayTinhByMaPhong(String maPhong);

    @Query("select mt from MayTinh mt where mt.mamay = ?1")
    MayTinh findByMaMay(String mamay);
}
