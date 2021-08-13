package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.repositories.ThoiKhoaBieuRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThoiKhoaBieuService {
    @Autowired
    private ThoiKhoaBieuRepository thoiKhoaBieuRepository;

    @Transactional
    public int checkTKB(String maphong, int thu, int end, int start){
        return thoiKhoaBieuRepository.checkTKB(maphong,thu,end,start);
    }
}
