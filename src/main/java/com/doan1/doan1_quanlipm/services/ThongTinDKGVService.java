package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.*;
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
    public void addTTDKGV(Users user, PhongMay phongMay, LopHocPhan lopHocPhan, Date thoigiandk, Date ngaysd, int start, int end, String mucdich, int soluongsv, int ketqua){
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
    public List<ThongTinDKGV> findByNQLMaPhong(String maphong, int ketqua){
        return thongTinDKGVRepository.findByMaPhongNQL(maphong, ketqua);
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
    public void editTTDKGV(Long id, Users user, PhongMay phongMay, LopHocPhan lopHocPhan, Date thoigiandk, Date ngaysd, int start, int end, String mucdich, int soluongsv, int ketqua){
        ThongTinDKGV thongTinDKGV = thongTinDKGVRepository.findById(id).get();
        thongTinDKGV.setUser(user);
        thongTinDKGV.setPhongmay(phongMay);
        thongTinDKGV.setLophp(lopHocPhan);
        thongTinDKGV.setThoigiandk(thoigiandk);
        thongTinDKGV.setNgaysd(ngaysd);
        thongTinDKGV.setTutiet(start);
        thongTinDKGV.setDentiet(end);
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
    public int checkTTDKGV(String maphong, Date ngaysd, int start, int end, int ketqua){
        return thongTinDKGVRepository.checkTTDKGV(maphong, ngaysd, start, end, ketqua);
    }


    @Transactional
    public void aceptTTKDGV(Long id){
        ThongTinDKGV thongTinDKGV = thongTinDKGVRepository.findById(id).get();
        thongTinDKGV.setKetqua(1);
        thongTinDKGVRepository.save(thongTinDKGV);
    }
    @Transactional
    public void denyTTKDGVByTimeRange(String maphong, Date ngaysd, int end, int start, int ketqua){
        List<ThongTinDKGV> thongTinDKGVs = thongTinDKGVRepository.findByTimeRange(maphong, ngaysd, end, start, ketqua);
        for(int i = 0; i < thongTinDKGVs.size(); i++){
            thongTinDKGVs.get(i).setKetqua(2);
            thongTinDKGVRepository.save(thongTinDKGVs.get(i));
        }
    }
}
