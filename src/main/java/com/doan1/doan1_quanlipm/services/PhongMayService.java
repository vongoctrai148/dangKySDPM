package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.repositories.PhongMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhongMayService {
    @Autowired
    private PhongMayRepository phongMayRepository;

    @Transactional
    public List<PhongMay> findAll(){
        return phongMayRepository.findAll();
    }
    @Transactional
    public PhongMay findByMaPhong(String maphong){
        return phongMayRepository.findByMaPhong(maphong);
    }
}
