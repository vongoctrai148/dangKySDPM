package com.doan1.doan1_quanlipm.controllers.giaovien;

import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.services.ThongTinDKGVService;
import com.doan1.doan1_quanlipm.services.ThongTinDKSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Duyet_SVDK_Controller {

    @Autowired
    private ThongTinDKGVService thongTinDKGVService;
    @Autowired
    private ThongTinDKSVService thongTinDKSVService;

    @GetMapping("GV/dsachphongmuon")
    public String getDsachPhong(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("dsttdk", thongTinDKGVService.findByUsernameAndKQ(user.getUsername(), 1));
            List<ThongTinDKGV> thongTinDKGVList = thongTinDKGVService.findByUsername(user.getUsername());
            for (int i = 0; i< thongTinDKGVList.size(); i++) {
                model.addAttribute("sosvmuon", thongTinDKSVService.countSVMuon(thongTinDKGVList.get(i).getPhongmay().getMaphong(),
                        thongTinDKGVList.get(i).getNgaysd(), thongTinDKGVList.get(i).getGiobatdau(), 0));
            }
            return "GV/dsachphongmuon";
        }
    }
    @GetMapping("GV/duyetsvdk/{id}")
    public String getDuyetSVDK(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        session.setAttribute("ttdkgvid", id);
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(id);
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            model.addAttribute("ttdksvs", thongTinDKSVService.findSVMuonPhong(thongTinDKGV.getPhongmay().getMaphong(), thongTinDKGV.getNgaysd(), thongTinDKGV.getGiobatdau(), 0));
            return "GV/duyetsvdk";
        }
    }
    @GetMapping("GV/aceptDKSV/{id}")
    public String getAceptDKSV(@PathVariable("id") Long id, HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        thongTinDKSVService.aceptDKSV(id);
        return "redirect:/GV/duyetsvdk/"+ttdkgvid;
    }
    @GetMapping("GV/aceptAll")
    public String getAceptAll(HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(ttdkgvid);
        thongTinDKSVService.aceptAll(thongTinDKGV.getPhongmay().getMaphong(), thongTinDKGV.getNgaysd(), thongTinDKGV.getGiobatdau(), 0);
        return "redirect:/GV/duyetsvdk/"+ttdkgvid;
    }
    @GetMapping("GV/denyDKSV/{id}")
    public String getDenyDKSV(@PathVariable("id") Long id, HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        thongTinDKSVService.denyDKSV(id);
        return "redirect:/GV/duyetsvdk/"+ttdkgvid;
    }
    @GetMapping("GV/denyAll")
    public String getDenyAll(HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(ttdkgvid);
        thongTinDKSVService.denytAll(thongTinDKGV.getPhongmay().getMaphong(), thongTinDKGV.getNgaysd(), thongTinDKGV.getGiobatdau(), 0);
        return "redirect:/GV/duyetsvdk/"+ttdkgvid;

    }
}
