package com.doan1.doan1_quanlipm.services;


import com.doan1.doan1_quanlipm.entities.PhanMem;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.entities.ThongTinDangKyPhanMem;
import com.doan1.doan1_quanlipm.repositories.ThongTinDKPMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThongTinDKPMService {
    @Autowired
    private ThongTinDKPMRepository thongTinDKPMRepository;
    @Transactional
    public void addUngDung(ThongTinDKSV thongTinDKSV, PhanMem phanMem){
        thongTinDKPMRepository.save(new ThongTinDangKyPhanMem(thongTinDKSV,
                phanMem));
    }

    @Transactional
    public List<ThongTinDangKyPhanMem> findByTTDKSVId(Long id){
        return thongTinDKPMRepository.findByTTDKSVId(id);
    }
    @Transactional
    public List<ThongTinDangKyPhanMem> findByTTDKGVId(Long id){
        return thongTinDKPMRepository.findByTTDKGVId(id);
    }

    @Transactional
    public void deleteByTTDKSVId(Long id){
        thongTinDKPMRepository.deleteByTTDKSVId(id);
    }

    @Transactional
    public void addUngDungGV(ThongTinDKGV thongTinDKGV, PhanMem phanMem){
        thongTinDKPMRepository.save(new ThongTinDangKyPhanMem(thongTinDKGV,phanMem));
    }

    @Transactional
    public void deleteByTTDKGVId(Long id){
        thongTinDKPMRepository.deleteByTTDKGVId(id);
    }

}
