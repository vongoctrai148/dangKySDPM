package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.repositories.MayTinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Temporal;
import java.util.List;

@Service
public class MayTinhService {
    @Autowired
    private MayTinhRepository mayTinhRepository;

    @Transactional
    public List<MayTinh> getMayTinhByMaPhong(String maPhong){
        return mayTinhRepository.getMayTinhByMaPhong(maPhong);
    }
    @Transactional
    public List<MayTinh> findAll(){
        return mayTinhRepository.findAll();
    }
    @Transactional
    public MayTinh findByMaMay(String mamay){
        return mayTinhRepository.findByMaMay(mamay);
    }
}
