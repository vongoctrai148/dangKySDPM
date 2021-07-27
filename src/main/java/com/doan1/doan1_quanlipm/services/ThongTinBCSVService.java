package com.doan1.doan1_quanlipm.services;


import com.doan1.doan1_quanlipm.entities.ThongTinBCSV;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.repositories.ThongTinBCSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ThongTinBCSVService {
    @Autowired
    private ThongTinBCSVRepository thongTinBCSVRepository;

    @Transactional
    public void themBaoCao(ThongTinDKSV thongTinDKSV, String tinhtrang, Date ngaybc, int tinhtrangxl){
        thongTinBCSVRepository.save(new ThongTinBCSV(thongTinDKSV,tinhtrang,ngaybc, tinhtrangxl));
    }

    @Transactional
    public ThongTinBCSV findByTTDKSVId(Long id){
        return thongTinBCSVRepository.findByTTDKSVId(id);
    }

    @Transactional
    public List<ThongTinBCSV> getTTBCByNQLUsername(String username, int tinhtrangxl){
        return thongTinBCSVRepository.getTTBCByNQLUsername(username, tinhtrangxl);
    }
    @Transactional
    public void quanTamBC(Long id){
        ThongTinBCSV thongTinBCSV = thongTinBCSVRepository.findById(id).get();
        thongTinBCSV.setTinhtrangxl(2);
        thongTinBCSVRepository.save(thongTinBCSV);
    }
    @Transactional
    public void daXuLiBC(Long id){
        ThongTinBCSV thongTinBCSV = thongTinBCSVRepository.findById(id).get();
        thongTinBCSV.setTinhtrangxl(1);
        thongTinBCSVRepository.save(thongTinBCSV);
    }
}
