package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.PhongMay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhongMayRepository extends JpaRepository<PhongMay,String>{
    @Query("select p from PhongMay p where p.maphong = ?1")
    PhongMay findByMaPhong(String maphong);

}
