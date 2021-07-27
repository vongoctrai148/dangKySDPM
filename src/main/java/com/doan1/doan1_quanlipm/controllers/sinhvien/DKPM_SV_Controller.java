package com.doan1.doan1_quanlipm.controllers.sinhvien;

import com.doan1.doan1_quanlipm.entities.*;
import com.doan1.doan1_quanlipm.services.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class DKPM_SV_Controller {
    @Autowired
    private ThongTinDKSVService thongTinDKSVService;
    @Autowired
    private ThongTinDKPMService thongTinDKPMService;
    @Autowired
    private PhongMayService phongMayService;
    @Autowired
    private MayTinhService mayTinhService;
    @Autowired
    private PhanMemService phanMemService;
    @Autowired
    private ThongTinDKGVService thongTinDKGVService;


    @GetMapping("SV/capnhatdkpm")
    public String getCapNhatDK(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else{
            model.addAttribute("thongtindk",
                    thongTinDKSVService.findAllByUserName(user.getUsername()));
        }
        return "SV/capnhatdkpm";
    }
    @GetMapping("SV/themdkpm")
    public String getThemDK(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("phongmay", phongMayService.findAll());
            return "SV/themdkpm";
        }
    }
    @PostMapping("SV/themdkpm")
    public String postThemDK(HttpServletRequest request, HttpSession session, Model model){
        String mamay = request.getParameter("maytinh");
        Users user = (Users) session.getAttribute("loginUser");
        String tgiansd = request.getParameter("thoigiansd");
        String start = request.getParameter("startTime");
        String end = request.getParameter("endTime");
        java.util.Date date = new java.util.Date();
        PhongMay phongMay = phongMayService.findByMaPhong((String) session.getAttribute("phongmayId"));
        model.addAttribute("phanmems", phanMemService.findPhanMemByMaPhong(phongMay.getMaphong()));
        MayTinh mayTinh = mayTinhService.findByMaMay(mamay);
        thongTinDKSVService.themDK(user, phongMay, mayTinh, date,tgiansd, start, end , 0);
        if(thongTinDKGVService.checkTTDKGV(phongMay.getMaphong(), tgiansd, start, 1) > 0){
            return "redirect:/SV/capnhatdkpm";
        }
        else {
            return "SV/themungdung";
        }
    }
    @PostMapping("SV/themungdung")
    public String postThemUD(HttpServletRequest request, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            String[] phanmems = request.getParameterValues("phanmem");
            for (int i = 0; i < phanmems.length; i++) {
                PhanMem phanMem = phanMemService.findPhanMemById(phanmems[i]);
                thongTinDKPMService.addUngDung(
                        thongTinDKSVService.findThongTinDKSVByMaxId(thongTinDKSVService.findMaxId()), phanMem);
            }
            return "redirect:/SV/capnhatdkpm";
        }
    }
    @GetMapping("SV/suadkpm/{id}")
    public String getSuaDK(Model model, HttpSession session, @PathVariable("id") Long id){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdk", thongTinDKSVService.findById(id));
            model.addAttribute("phongmay", phongMayService.findAll());
            return "SV/suadkpm";
        }
    }
    @PostMapping("SV/suadkpm")
    public String postSuaDK(Model model, HttpServletRequest request, HttpSession session){
        Long id = Long.valueOf(request.getParameter("id"));
        session.setAttribute("ttdksvid", id);
        String mamay = request.getParameter("maytinh");
        Users user = (Users) session.getAttribute("loginUser");
        String tgiansd = request.getParameter("thoigiansd");
        String start = request.getParameter("startTime");
        String end = request.getParameter("endTime");
        java.util.Date date = new java.util.Date();
        PhongMay phongMay = phongMayService.findByMaPhong((String) session.getAttribute("phongmayId"));
        model.addAttribute("phanmems", phanMemService.findPhanMemByMaPhong(phongMay.getMaphong()));
        MayTinh mayTinh = mayTinhService.findByMaMay(mamay);
        thongTinDKSVService.suaDK(id, user, phongMay, mayTinh,date ,tgiansd, start, end , 0);
        if(thongTinDKGVService.checkTTDKGV(phongMay.getMaphong(), tgiansd, start, 1) > 0){
            return "redirect:/SV/capnhatdkpm";
        }
        else {
            return "SV/suaungdung";
        }
    }
    @GetMapping("/SV/suaungdung")
    public String getSuaUD(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            return "SV/suaungdung";
        }
    }
    @PostMapping("/SV/suaungdung")
    public String postSuaUD(HttpServletRequest request, HttpSession session){
        Long id = (Long) session.getAttribute("ttdksvid");
        String[] phanmems = request.getParameterValues("phanmem");
        thongTinDKPMService.deleteByTTDKSVId(id);
        for (int i = 0; i < phanmems.length; i++) {
            PhanMem phanMem = phanMemService.findPhanMemById(phanmems[i]);
            thongTinDKPMService.addUngDung(thongTinDKSVService.findById(id), phanMem);
        }
        return "redirect:/SV/capnhatdkpm";
    }
    @GetMapping("SV/deletettdk/{id}")
    public String getDeletettdk(@PathVariable("id") Long id){
        thongTinDKPMService.deleteByTTDKSVId(id);
        thongTinDKSVService.deleteTTDK(id);
        return "/SV/capnhatdkpm";
    }
}
