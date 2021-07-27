package com.doan1.doan1_quanlipm.controllers.sinhvien;

import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.repositories.ThongTinBCSVRepository;
import com.doan1.doan1_quanlipm.services.ThongTinBCSVService;
import com.doan1.doan1_quanlipm.services.ThongTinDKPMService;
import com.doan1.doan1_quanlipm.services.ThongTinDKSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.GroupSequence;

@Controller
public class LichSuDKController {
    @Autowired
    private ThongTinDKSVService thongTinDKSVService;
    @Autowired
    private ThongTinDKPMService thongTinDKPMService;
    @Autowired
    private ThongTinBCSVService thongTinBCSVService;

    @GetMapping("SV/lichsudk")
    public String getHistory(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdksvs", thongTinDKSVService.findAllByUserName(user.getUsername()));
            return "SV/lichsudk";
        }
    }
    @GetMapping("SV/chitietlichsu/{id}")
    public String getHistoryDetail(HttpSession session, @PathVariable("id") Long id, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdksv", thongTinDKSVService.findById(id));
            model.addAttribute("phanmems", thongTinDKPMService.findByTTDKSVId(id));
            return "SV/chitietlichsu";
        }
    }
    @GetMapping("SV/baocaomay/{id}")
    public String getResponse(HttpSession session, Model model, @PathVariable("id") Long id){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttdksv", thongTinDKSVService.findById(id));
            return "SV/baocaomay";
        }
    }
    @PostMapping("SV/baocaomay")
    public String postResponse(Model model, HttpServletRequest request, HttpSession session){
        Long id = Long.valueOf(request.getParameter("id"));
        session.setAttribute("ttdksvid", id);
        String tinhtrang = request.getParameter("tinhtrang");
        java.util.Date date = new java.util.Date();
        thongTinBCSVService.themBaoCao(thongTinDKSVService.findById(id), tinhtrang, date, 0);
        return "SV/baocaothanhcong";
    }

    @GetMapping("SV/baocaothanhcong")
    public String getRespondSuccess(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        Long id = (Long) session.getAttribute("ttdksvid");
        if(("").equals(user) || user == null)
            return "redirect:/login";
        else {
            model.addAttribute("ttbcsv", thongTinBCSVService.findByTTDKSVId(id));
            return "SV/baocaothanhcong";
        }
    }

}
