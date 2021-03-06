package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ThongTinDKSVRepository extends JpaRepository<ThongTinDKSV, Long> {
    @Query("select tt from ThongTinDKSV tt, Users u where " +
            "u.username = tt.user.username  and tt.user.username = ?1 order by tt.thoigiandk desc")
    List<ThongTinDKSV> findAllByUsername(String username);
    @Query("select max(tt.id) from ThongTinDKSV tt")
    Long findMaxId();

    @Query("select tt from ThongTinDKSV tt where tt.id = ?1")
    ThongTinDKSV findThongTinDKSVByMaxId(Long id);

    @Query("select count(tt) from ThongTinDKSV tt where tt.maphong.maphong = ?1 and tt.ngaysd = ?2 and tt.tutiet < ?3 and tt.dentiet > ?4 and tt.ketqua = ?5 ")
    int countSVMuonPhong(String maphong, Date ngaysd, int end, int start, int ketqua);

    @Query("select tt from ThongTinDKSV tt where tt.maphong.maphong = ?1 and tt.ngaysd = ?2 and tt.tutiet = ?3 and tt.ketqua = ?4 ")
    List<ThongTinDKSV> findSVMuonPhong(String maphong, Date ngaysd, int giobatdau, int ketqua);
    @Query("select tt from ThongTinDKSV tt where tt.maphong.maphong = ?1 and tt.ketqua = ?2 order by tt.thoigiandk asc ")
    List<ThongTinDKSV> getSVMuonMayNQL(String maphong, int ketqua);

    @Query("select count(tt) from ThongTinDKSV tt where tt.maphong.maphong = ?1 and tt.mamay.mamay = ?2 and tt.ngaysd = ?3 and tt.tutiet < ?4 and tt.dentiet > ?5 and tt.ketqua = ?6")
    int checkTTDKSV(String maphong, String mamay, Date ngaysd, int giobatdau, int dentiet, int ketqua);
}
