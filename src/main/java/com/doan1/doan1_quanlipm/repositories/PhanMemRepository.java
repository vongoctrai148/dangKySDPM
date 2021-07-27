package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.PhanMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhanMemRepository extends JpaRepository<PhanMem, String> {
    @Query("select distinct pm from PhanMem pm, MayTinh mt, PhanMemMayTinh pmmt, PhongMay p where " +
            "pm.maphanmem = pmmt.phanmem.maphanmem and mt.phongmay.maphong=p.maphong and pmmt.maytinh.mamay = mt.mamay and mt.phongmay.maphong = ?1")
    List<PhanMem> findPhanMemByMaPhong(String maphong);

    @Query("select pm from PhanMem pm where pm.maphanmem = ?1")
    PhanMem findPhanMemById(String id);
}
