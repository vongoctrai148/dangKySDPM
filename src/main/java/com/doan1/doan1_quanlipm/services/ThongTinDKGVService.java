package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.LopHocPhan;
import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.repositories.ThongTinDKGVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ThongTinDKGVService {
    @Autowired
    private ThongTinDKGVRepository thongTinDKGVRepository;

    @Transactional
    public List<ThongTinDKGV> findAll(){
        return thongTinDKGVRepository.findAll();
    }

    @Transactional
    public void addTTDKGV(Users user, PhongMay phongMay, LopHocPhan lopHocPhan, Date thoigiandk, Date ngaysd, String start, String end, String mucdich, int soluongsv, int ketqua){
        thongTinDKGVRepository.save(new ThongTinDKGV(user, phongMay, lopHocPhan, thoigiandk, ngaysd, start, end, mucdich, soluongsv, ketqua));
    }
    @Transactional
    public ThongTinDKGV findById(Long id){
        return thongTinDKGVRepository.findById(id).get();
    }
    @Transactional
    public Long findMaxId(){
        return thongTinDKGVRepository.findMaxId();
    }
    @Transactional
    public List<ThongTinDKGV> findByUsername(String username){
        return thongTinDKGVRepository.findByUsername(username);
    }
    @Transactional
    public List<ThongTinDKGV> findByNQLUsername(String username, int ketqua){
        return thongTinDKGVRepository.findByNQLUsername(username, ketqua);
    }
    @Transactional
    public List<ThongTinDKGV> findByUsernameAndKQ(String username, int ketqua){
        return thongTinDKGVRepository.findByUsernameAndKQ(username, ketqua);
    }
    @Transactional
    public List<ThongTinDKGV> findByNQLUsernameToRP(String username){
        return thongTinDKGVRepository.findByNQLUsernameToRP(username);
    }
    @Transactional
    public void editTTDKGV(Long id, Users user, PhongMay phongMay, LopHocPhan lopHocPhan, Date thoigiandk, Date ngaysd, String start, String end, String mucdich, int soluongsv, int ketqua){
        ThongTinDKGV thongTinDKGV = thongTinDKGVRepository.findById(id).get();
        thongTinDKGV.setUser(user);
        thongTinDKGV.setPhongmay(phongMay);
        thongTinDKGV.setLophp(lopHocPhan);
        thongTinDKGV.setThoigiandk(thoigiandk);
        thongTinDKGV.setNgaysd(ngaysd);
        thongTinDKGV.setGiobatdau(start);
        thongTinDKGV.setGioketthuc(end);
        thongTinDKGV.setMucdich(mucdich);
        thongTinDKGV.setSoluongsv(soluongsv);
        thongTinDKGV.setKetqua(ketqua);
        thongTinDKGVRepository.save(thongTinDKGV);
    }
    @Transactional
    public void deleteById(Long id){
        thongTinDKGVRepository.deleteById(id);
    }

    @Transactional
    public int checkTTDKGV(String maphong, Date ngaysd, String start, int ketqua){
        return thongTinDKGVRepository.checkTTDKGV(maphong, ngaysd, start, ketqua);
    }
    @Transactional
    public void aceptTTKDGV(Long id){
        ThongTinDKGV thongTinDKGV = thongTinDKGVRepository.findById(id).get();
        thongTinDKGV.setKetqua(1);
        thongTinDKGVRepository.save(thongTinDKGV);
    }
    @Transactional
    public void denyTTKDGV(Long id){
        ThongTinDKGV thongTinDKGV = thongTinDKGVRepository.findById(id).get();
        thongTinDKGV.setKetqua(2);
        thongTinDKGVRepository.save(thongTinDKGV);
    }
}
