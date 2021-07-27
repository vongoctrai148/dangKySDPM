package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ThongTinBCSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThongTinBCSVRepository extends JpaRepository<ThongTinBCSV, Long> {
    @Query("select ttbc from ThongTinBCSV ttbc where ttbc.thongTinDKSV.id = ?1")
    ThongTinBCSV findByTTDKSVId(Long id);

    @Query("select ttbc from ThongTinBCSV ttbc, PhongMay pm where pm.user.username = ?1 and ttbc.tinhtrangxl = ?2")
    List<ThongTinBCSV> getTTBCByNQLUsername(String uesrname, int tinhtrangxl);
}
