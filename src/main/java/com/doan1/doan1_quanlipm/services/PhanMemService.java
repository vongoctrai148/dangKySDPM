package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.PhanMem;
import com.doan1.doan1_quanlipm.repositories.PhanMemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhanMemService {
    @Autowired
    private PhanMemRepository phanMemRepository;

    @Transactional
    public List<PhanMem> findPhanMemByMaPhong(String maphong){
        return phanMemRepository.findPhanMemByMaPhong(maphong);
    }
    @Transactional
    public PhanMem findPhanMemById(String id){
        return phanMemRepository.findPhanMemById(id);
    }
}
