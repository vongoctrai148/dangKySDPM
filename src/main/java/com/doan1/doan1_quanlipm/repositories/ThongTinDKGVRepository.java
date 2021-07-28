package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ThongTinDKGVRepository extends JpaRepository<ThongTinDKGV, Long> {
    @Query("select max(tt.id) from ThongTinDKGV tt")
    Long findMaxId();

    @Query("select tt from ThongTinDKGV tt where tt.user.username = ?1")
    List<ThongTinDKGV> findByUsername(String username);

    @Query("select tt from ThongTinDKGV tt, PhongMay pm where pm.user.username = ?1 and tt.ketqua = ?2 order by tt.thoigiandk asc ")
    List<ThongTinDKGV> findByNQLUsername(String username, int ketqua);

    @Query("select tt from ThongTinDKGV tt, PhongMay pm where pm.user.username = ?1 order by tt.thoigiandk asc ")
    List<ThongTinDKGV> findByNQLUsernameToRP(String username);

    @Query("select tt from ThongTinDKGV tt where tt.user.username = ?1 and tt.ketqua = ?2")
    List<ThongTinDKGV> findByUsernameAndKQ(String usernamem, int ketqua);

    @Query("select count(tt) from ThongTinDKGV tt where tt.phongmay.maphong = ?1 and tt.ngaysd = ?2 and tt.giobatdau = ?3 and tt.ketqua = ?4")
    int checkTTDKGV(String maphong, Date ngaysd, String giobatdau, int ketqua);
}
