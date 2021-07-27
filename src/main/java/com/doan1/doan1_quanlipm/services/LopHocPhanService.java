package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.LopHocPhan;
import com.doan1.doan1_quanlipm.repositories.LopHocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LopHocPhanService {
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @Transactional
    public List<LopHocPhan> findByUsername(String username){
        return lopHocPhanRepository.findByUsername(username);
    }

    @Transactional
    public LopHocPhan findByMaLHP(String malhp){
        return lopHocPhanRepository.findByMaLHP(malhp);
    }
}
