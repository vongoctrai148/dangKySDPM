package com.doan1.doan1_quanlipm.controllers.nguoiquanli;

import com.doan1.doan1_quanlipm.entities.ChiTietBCMay;
import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.services.ChiTietBCMayService;
import com.doan1.doan1_quanlipm.services.ThongTinDKGVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class TraLoiBC_GV {
    @Autowired
    private ChiTietBCMayService chiTietBCMayService;
    @Autowired
    private ThongTinDKGVService thongTinDKGVService;

    @GetMapping("NQL/dsachBCGV")
    public String getDSBCGV(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("danhsachbcgv", chiTietBCMayService.getTTBCGVByNQLUsername(user.getUsername(), 0));
            return "NQL/dsachBCGV";
        }
    }
    @GetMapping("NQL/chitietBCGV/{id}")
    public String getChiTietBCGV(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        session.setAttribute("ttdkgvid", id);
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            model.addAttribute("dsachbcmay", chiTietBCMayService.findByTTDKGVId(id));
            return "NQL/chitietBCGV";
        }
    }
    @GetMapping("NQL/quantamBCGV/{id}")
    public String getQuanTamBCGV(@PathVariable("id") Long id, HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        chiTietBCMayService.quanTamBCGV(id);
        return "redirect:/NQL/chitietBCGV/"+ttdkgvid;
    }
    @GetMapping("NQL/xuliBCGV/{id}")
    public String getXuLiBCGV(@PathVariable("id") Long id, HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        chiTietBCMayService.xuliBCGV(id);
        return "redirect:/NQL/chitietBCGV/"+ttdkgvid;
    }
}
