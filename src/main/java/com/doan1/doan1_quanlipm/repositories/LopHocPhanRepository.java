package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, String> {
    @Query("select l from LopHocPhan l where l.user.username = ?1")
    List<LopHocPhan> findByUsername(String username);

    @Query("select l from LopHocPhan l where l.malhp = ?1")
    LopHocPhan findByMaLHP(String malhp);
}
