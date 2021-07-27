package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ThongTinDangKyPhanMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ThongTinDKPMRepository extends JpaRepository<ThongTinDangKyPhanMem, Long> {
    @Query("select dkpm from ThongTinDangKyPhanMem dkpm, ThongTinDKSV ttdk where ttdk.id = dkpm.thongtindksv.id and dkpm.thongtindksv.id = ?1")
    List<ThongTinDangKyPhanMem> findByTTDKSVId(Long id);
    @Query("select dkpm from ThongTinDangKyPhanMem dkpm, ThongTinDKGV ttdk where ttdk.id = dkpm.thongtindkgv.id and dkpm.thongtindkgv.id = ?1")
    List<ThongTinDangKyPhanMem> findByTTDKGVId(Long id);
    @Transactional
    @Modifying
    @Query("delete from ThongTinDangKyPhanMem dkpm where dkpm.thongtindksv.id = ?1")
    void deleteByTTDKSVId(Long id);

    @Transactional
    @Modifying
    @Query("delete from ThongTinDangKyPhanMem dkpm where dkpm.thongtindkgv.id = ?1")
    void deleteByTTDKGVId(Long id);
}
