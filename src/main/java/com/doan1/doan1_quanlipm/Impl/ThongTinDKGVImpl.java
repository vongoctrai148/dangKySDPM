package com.doan1.doan1_quanlipm.Impl;

import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.repositories.ThongTinDKGVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThongTinDKGVImpl implements ThongTinDKGVReport {
    @Autowired
    private ThongTinDKGVRepository thongTinDKGVRepository;

    @Override
    public List<Map<String, Object>> report() {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (ThongTinDKGV thongTinDKGV : thongTinDKGVRepository.findAll()) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", thongTinDKGV.getId());
            item.put("username", thongTinDKGV.getUser().getUsername());
            item.put("hoten", thongTinDKGV.getUser().getHoten());
            item.put("phongmay", thongTinDKGV.getPhongmay().getMaphong());
            item.put("thoigiandk", thongTinDKGV.getThoigiandk());
            item.put("malhp", thongTinDKGV.getLophp().getMalhp());
            item.put("ngaysd", thongTinDKGV.getNgaysd());
            item.put("start", thongTinDKGV.getGiobatdau());
            item.put("end", thongTinDKGV.getGioketthuc());
            result.add(item);
        }
        return result;
    }
}
