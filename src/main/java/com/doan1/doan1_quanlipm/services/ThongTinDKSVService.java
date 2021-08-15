package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.repositories.ThongTinDKSVRepository;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class ThongTinDKSVService {
    @Autowired
    private ThongTinDKSVRepository thongTinDKSVRepository;


    @Transactional
    public List<ThongTinDKSV> findAllByUserName(String username){
        return thongTinDKSVRepository.findAllByUsername(username);
    }
    @Transactional
    public int checkTTDKSV(String maphong, String mamay, Date ngaysd, int start, int end, int ketqua){
        return thongTinDKSVRepository.checkTTDKSV(maphong, mamay, ngaysd, start, end, ketqua);
    }


    @Transactional
    public void themDK(Users user, PhongMay phongmay, MayTinh maytinh, Date thoigiandk,Date ngaysd,
                       int tutiet, int dentiet, int ketqua){
        thongTinDKSVRepository.save(new ThongTinDKSV(user, phongmay, maytinh, thoigiandk, ngaysd, tutiet, dentiet, ketqua));
    }
    @Transactional
    public Long findMaxId(){
        return thongTinDKSVRepository.findMaxId();
    }
    @Transactional
    public ThongTinDKSV findThongTinDKSVByMaxId(Long id){
        return thongTinDKSVRepository.findThongTinDKSVByMaxId(id);
    }

    @Transactional
    public ThongTinDKSV findById(Long id){
        return thongTinDKSVRepository.findById(id).get();
    }

    @Transactional
    public void suaDK(Long id, Users users, PhongMay phongmay, MayTinh maytinh, Date thoigiandk, Date ngaysd,
                              int start, int end, int ketqua){
        ThongTinDKSV thongTinDKSV = thongTinDKSVRepository.findById(id).get();
        thongTinDKSV.setUser(users);
        thongTinDKSV.setMaphong(phongmay);
        thongTinDKSV.setMamay(maytinh);
        thongTinDKSV.setThoigiandk(thoigiandk);
        thongTinDKSV.setNgaysd(ngaysd);
        thongTinDKSV.setTutiet(start);
        thongTinDKSV.setDentiet(end);
        thongTinDKSV.setKetqua(ketqua);
        thongTinDKSVRepository.save(thongTinDKSV);
    }

    @Transactional
    public void deleteTTDK(Long id){
        thongTinDKSVRepository.deleteById(id);
    }

    @Transactional
    public int countSVMuon(String maphong, Date ngaysd, int end, int start, int ketqua){
        return thongTinDKSVRepository.countSVMuonPhong(maphong, ngaysd, end, start, ketqua);
    }
    @Transactional
    public List<ThongTinDKSV> findSVMuonPhong(String maphong, Date ngaysd, int start, int ketqua){
        return thongTinDKSVRepository.findSVMuonPhong(maphong, ngaysd, start, ketqua);
    }
    @Transactional
    public List<ThongTinDKSV> getSVMuonMayNQL(String maphong, int ketqua){
        return thongTinDKSVRepository.getSVMuonMayNQL(maphong, ketqua);
    }
    @Transactional
    public void aceptDKSV(Long id){
        ThongTinDKSV thongTinDKSV = thongTinDKSVRepository.findById(id).get();
        thongTinDKSV.setKetqua(1);
        thongTinDKSVRepository.save(thongTinDKSV);
    }
    @Transactional
    public void denyDKSV(Long id){
        ThongTinDKSV thongTinDKSV = thongTinDKSVRepository.findById(id).get();
        thongTinDKSV.setKetqua(2);
        thongTinDKSVRepository.save(thongTinDKSV);
    }
    @Transactional
    public void aceptAll(String maphong, Date ngaysd, int giobatdau, int ketqua){
        List<ThongTinDKSV> thongTinDKSVs = thongTinDKSVRepository.findSVMuonPhong(maphong, ngaysd, giobatdau, ketqua);
        for(int i = 0; i < thongTinDKSVs.size(); i++){
            thongTinDKSVs.get(i).setKetqua(1);
            thongTinDKSVRepository.save(thongTinDKSVs.get(i));
        }
    }
    @Transactional
    public void aceptAllByNQL(String username, int ketqua){
        List<ThongTinDKSV> thongTinDKSVs = thongTinDKSVRepository.getSVMuonMayNQL(username, ketqua);
        for(int i = 0; i < thongTinDKSVs.size(); i++){
            thongTinDKSVs.get(i).setKetqua(1);
            thongTinDKSVRepository.save(thongTinDKSVs.get(i));
        }
    }
    @Transactional
    public void denytAll(String maphong, Date ngaysd, int giobatdau, int ketqua){
        List<ThongTinDKSV> thongTinDKSVs = thongTinDKSVRepository.findSVMuonPhong(maphong, ngaysd, giobatdau, ketqua);
        for(int i = 0; i < thongTinDKSVs.size(); i++){
            thongTinDKSVs.get(i).setKetqua(2);
            thongTinDKSVRepository.save(thongTinDKSVs.get(i));
        }
    }
    @Transactional
    public void denyAllByNQL(String username, int ketqua){
        List<ThongTinDKSV> thongTinDKSVs = thongTinDKSVRepository.getSVMuonMayNQL(username, ketqua);
        for(int i = 0; i < thongTinDKSVs.size(); i++){
            thongTinDKSVs.get(i).setKetqua(1);
            thongTinDKSVRepository.save(thongTinDKSVs.get(i));
        }
    }
}
