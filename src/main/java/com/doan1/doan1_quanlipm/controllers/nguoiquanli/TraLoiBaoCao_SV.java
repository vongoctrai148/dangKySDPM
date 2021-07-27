package com.doan1.doan1_quanlipm.controllers.nguoiquanli;

import com.doan1.doan1_quanlipm.entities.ThongTinBCSV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.services.ThongTinBCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class TraLoiBaoCao_SV {
    @Autowired
    private ThongTinBCSVService thongTinBCSVService;

    @GetMapping("NQL/dsachBCSV")
    public String getDSBCSV(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("dsachbcsv", thongTinBCSVService.getTTBCByNQLUsername(user.getUsername(), 0));
            return "NQL/dsachBCSV";
        }
    }
    @GetMapping("NQL/chitietBC/{id}")
    public String getChiTietBCSV(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        session.setAttribute("ttdksvid", id);
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttbcsv", thongTinBCSVService.findByTTDKSVId(id));
            return "NQL/chitietBC";
        }
    }
    @GetMapping("NQL/quantam/{id}")
    public String getQuanTam(HttpSession session, @PathVariable("id") Long id){
        Long ttdksvid = (Long) session.getAttribute("ttdksvid");
        thongTinBCSVService.quanTamBC(id);
        return "redirect:/NQL/chitietBC/" + ttdksvid;
    }
    @GetMapping("NQL/xuli/{id}")
    public String getXuLi(HttpSession session, @PathVariable("id") Long id){
        Long ttdksvid = (Long) session.getAttribute("ttdksvid");
        thongTinBCSVService.daXuLiBC(id);
        return "redirect:/NQL/chitietBC/" + ttdksvid;
    }
}
