package com.doan1.doan1_quanlipm.controllers.giaovien;

import com.doan1.doan1_quanlipm.entities.LopHocPhan;
import com.doan1.doan1_quanlipm.entities.PhanMem;
import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.repositories.LopHocPhanRepository;
import com.doan1.doan1_quanlipm.services.*;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class DKPM_GV_Controller {
    @Autowired
    private ThongTinDKGVService thongTinDKGVService;
    @Autowired
    private LopHocPhanService lopHocPhanService;
    @Autowired
    private PhongMayService phongMayService;
    @Autowired
    private PhanMemService phanMemService;
    @Autowired
    private ThongTinDKPMService thongTinDKPMService;

    @GetMapping("/GV/capnhatdkpm")
    public String getCapNhatDK(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("loginUser");
        if (("").equals(user) || user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findByUsername(user.getUsername()));
            return "GV/capnhatdkpm";
        }
    }

    @GetMapping("GV/themdkpm")
    public String getThemDK(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("lophp", lopHocPhanService.findByUsername(user.getUsername()));
            model.addAttribute("phongmays", phongMayService.findAll());
            return "GV/themdkpm";
        }
    }
    @PostMapping("GV/themdkpm")
    public String postThemDK(HttpServletRequest request, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        PhongMay phongMay = phongMayService.findByMaPhong(request.getParameter("phongmay"));
        LopHocPhan lopHocPhan = lopHocPhanService.findByMaLHP(request.getParameter("lophocphan"));
        Date ngaysd = Date.valueOf(request.getParameter("ngaysd"));
        java.util.Date date = new java.util.Date();
        String start = request.getParameter("startTime");
        String end = request.getParameter("endTime");
        int soluongsv = Integer.parseInt(request.getParameter("soluongsv"));
        String[] mucdichs = request.getParameterValues("mucdich");
        StringBuilder mucdich = new StringBuilder("");
        for (int i = 0; i < mucdichs.length; i++){
            mucdich.append(mucdichs[i]);
        }
        model.addAttribute("phanmems", phanMemService.findPhanMemByMaPhong(phongMay.getMaphong()));
        if(thongTinDKGVService.checkTTDKGV(phongMay.getMaphong(), ngaysd, start, 1) > 0){
            model.addAttribute("message", "Phòng đã có giáo viên mượn");
            return "redirect:/GV/themdkpm";
        }
        else {
            thongTinDKGVService.addTTDKGV(user, phongMay, lopHocPhan, date, ngaysd, start, end, mucdich.toString(), soluongsv, 0);
            return "GV/themungdung";
        }
    }
    @PostMapping("GV/themungdung")
    public String postThemUD(HttpServletRequest request, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            String[] phanmems = request.getParameterValues("phanmem");
            for (int i = 0; i < phanmems.length; i++) {
                PhanMem phanMem = phanMemService.findPhanMemById(phanmems[i]);
                thongTinDKPMService.addUngDungGV(
                        thongTinDKGVService.findById(thongTinDKGVService.findMaxId()), phanMem);
            }
            return "redirect:/GV/capnhatdkpm";
        }
    }
    @GetMapping("GV/suadkpm/{id}")
    public String getSuaDKPM(HttpSession session, Model model, @PathVariable("id") Long id){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            model.addAttribute("lophp", lopHocPhanService.findByUsername(user.getUsername()));
            model.addAttribute("phongmays", phongMayService.findAll());
            return "GV/suadkpm";
        }
    }
    @PostMapping("GV/suadkpm")
    public String postSuaDK(HttpServletRequest request, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        Long id = Long.valueOf(request.getParameter("id"));
        session.setAttribute("ttdkgvid", id);
        PhongMay phongMay = phongMayService.findByMaPhong(request.getParameter("phongmay"));
        LopHocPhan lopHocPhan = lopHocPhanService.findByMaLHP(request.getParameter("lophocphan"));
        Date ngaysd = Date.valueOf(request.getParameter("ngaysd"));
        java.util.Date date = new java.util.Date();
        String start = request.getParameter("startTime");
        String end = request.getParameter("endTime");
        int soluongsv = Integer.parseInt(request.getParameter("soluongsv"));
        String[] mucdichs = request.getParameterValues("mucdich");
        StringBuilder mucdich = new StringBuilder("");
        for (int i = 0; i < mucdichs.length; i++){
            mucdich.append(mucdichs[i]);
        }
        model.addAttribute("phanmems", phanMemService.findPhanMemByMaPhong(phongMay.getMaphong()));
        if(thongTinDKGVService.checkTTDKGV(phongMay.getMaphong(), ngaysd, start, 1) > 0){
            model.addAttribute("message", "Phòng đã có giáo viên mượn");
            return "redirect:/GV/suadkpm/"+id;
        }
        else {
            thongTinDKGVService.editTTDKGV(id, user, phongMay, lopHocPhan, date, ngaysd, start, end, mucdich.toString(), soluongsv, 0);
            return "GV/suaungdung";
        }
    }
    @GetMapping("/GV/suaungdung")
    public String getSuaUD(HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            return "GV/suaungdung";
        }
    }
    @PostMapping("/GV/suaungdung")
    public String postSuaUD(HttpServletRequest request, HttpSession session, Model model){
        Long id = (Long) session.getAttribute("ttdkgvid");
        String[] phanmems = request.getParameterValues("phanmem");
        thongTinDKPMService.deleteByTTDKGVId(id);
        model.addAttribute("id", id);
        model.addAttribute("phanmem", phanmems);
        for (int i = 0; i < phanmems.length; i++) {
            PhanMem phanMem = phanMemService.findPhanMemById(phanmems[i]);
            thongTinDKPMService.addUngDungGV(thongTinDKGVService.findById(id), phanMem);
        }
        return "redirect:/GV/capnhatdkpm";
    }
    @GetMapping("GV/deletettdk/{id}")
    public String getDeletettdk(@PathVariable("id") Long id){
        thongTinDKPMService.deleteByTTDKGVId(id);
        thongTinDKGVService.deleteById(id);
        return "redirect:/GV/capnhatdkpm";
    }
}
