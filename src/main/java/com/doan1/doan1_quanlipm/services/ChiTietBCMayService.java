package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.ChiTietBCMay;
import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.repositories.ChiTietBCMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.CharacterIterator;
import java.util.Date;
import java.util.List;

@Service
public class ChiTietBCMayService {
    @Autowired
    private ChiTietBCMayRepository chiTietBCMayRepository;

    @Transactional
    public List<ChiTietBCMay> findByTTDKGVId(Long id){
        return chiTietBCMayRepository.findByTTDKGVId(id);
    }

    @Transactional
    public void addBCMay(ThongTinDKGV thongTinDKGV, MayTinh mayTinh, String noidung, Date ngaybc, int tinhtrang){
        chiTietBCMayRepository.save(new ChiTietBCMay(thongTinDKGV, mayTinh, noidung, ngaybc, tinhtrang));
    }

    @Transactional
    public List<ChiTietBCMay> getTTBCGVByNQLUsername(String username, int tinhtrang){
        return chiTietBCMayRepository.getTTBCGVByNQLUsername(username, tinhtrang);
    }
    @Transactional
    public void quanTamBCGV(Long id){
        ChiTietBCMay chiTietBCMay = chiTietBCMayRepository.findById(id).get();
        chiTietBCMay.setTinhtrang(2);
        chiTietBCMayRepository.save(chiTietBCMay);
    }
    @Transactional
    public void xuliBCGV(Long id){
        ChiTietBCMay chiTietBCMay = chiTietBCMayRepository.findById(id).get();
        chiTietBCMay.setTinhtrang(1);
        chiTietBCMayRepository.save(chiTietBCMay);
    }
}
