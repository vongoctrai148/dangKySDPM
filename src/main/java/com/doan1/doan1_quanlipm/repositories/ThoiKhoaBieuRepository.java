package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ThoiKhoaBieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThoiKhoaBieuRepository extends JpaRepository<ThoiKhoaBieu, Long> {
    @Query("select count(tkb) from ThoiKhoaBieu tkb where tkb.maphong = ?1 and tkb.thu = ?2 and tkb.tutiet < ?3 and tkb.dentiet > ?4")
    int checkTKB(String maphong, int thu, int end, int start);
}
