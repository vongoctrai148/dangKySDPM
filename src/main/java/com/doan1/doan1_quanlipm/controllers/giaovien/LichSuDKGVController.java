package com.doan1.doan1_quanlipm.controllers.giaovien;

import com.doan1.doan1_quanlipm.entities.*;
import com.doan1.doan1_quanlipm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LichSuDKGVController {
    @Autowired
    private ThongTinDKGVService thongTinDKGVService;
    @Autowired
    private ThongTinDKPMService thongTinDKPMService;
    @Autowired
    private MayTinhService mayTinhService;
    @Autowired
    private ChiTietBCMayService chiTietBCMayService;

    @GetMapping("GV/lichsudk")
    public String getLichSuDK(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdkgvs", thongTinDKGVService.findByUsername(user.getUsername()));
            return "GV/lichsudk";
        }

    }
    @GetMapping("GV/chitietlichsu/{id}")
    public String getChiTietLichSu(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("phanmems", thongTinDKPMService.findByTTDKGVId(id));
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            return "GV/chitietlichsu";
        }
    }
    @GetMapping("GV/baocaophong/{id}")
    public String getBaoCaoPhong(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            model.addAttribute("bcmays", chiTietBCMayService.findByTTDKGVId(id));
            model.addAttribute("maytinhs", mayTinhService.getMayTinhByMaPhong(thongTinDKGVService.findById(id).getPhongmay().getMaphong()));
            return "GV/baocaophong";
        }
    }

    @PostMapping("GV/baocaophong")
    public String postBaoCaoPhong(){
        return "redirect:/GV/lichsudk";
    }
    @GetMapping("GV/baocaomay/{id}")
    public String getBaoCaoMay(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            model.addAttribute("maytinhs", mayTinhService.getMayTinhByMaPhong(thongTinDKGVService.findById(id).getPhongmay().getMaphong()));
            return "GV/baocaomay";
        }
    }
    @PostMapping("GV/baocaomay")
    public String postBaoCaoMay(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        java.util.Date ngaybc = new java.util.Date();
        ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(id);
        MayTinh mayTinh = mayTinhService.findByMaMay(request.getParameter("maytinh"));
        String noidung = request.getParameter("noidung");
        chiTietBCMayService.addBCMay(thongTinDKGV, mayTinh,noidung, ngaybc, 0);
        return "redirect:/GV/baocaophong/"+id;

    }
    @GetMapping("GV/baocaothanhcong")
    public String getBaoCaoTC(){
        return "GV/baocaothanhcong";
    }
}
