package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ChiTietBCMay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietBCMayRepository extends JpaRepository<ChiTietBCMay, Long> {
    @Query("select ct from ChiTietBCMay ct where ct.thongTinDKGV.id = ?1 ")
    List<ChiTietBCMay> findByTTDKGVId(Long id);

    @Query("select ct from ChiTietBCMay ct, PhongMay pm where pm.user.username = ?1 and ct.tinhtrang = ?2")
    List<ChiTietBCMay> getTTBCGVByNQLUsername(String username, int tinhtrang);
}
