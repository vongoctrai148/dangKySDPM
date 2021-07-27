package com.doan1.doan1_quanlipm.controllers.nguoiquanli;

import com.doan1.doan1_quanlipm.entities.ThongTinDKGV;
import com.doan1.doan1_quanlipm.entities.ThongTinDKSV;
import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.services.ThongTinDKGVService;
import com.doan1.doan1_quanlipm.services.ThongTinDKSVService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class DKPM_NQL_Controller {
    @Autowired
    private ThongTinDKGVService thongTinDKGVService;
    @Autowired
    private ThongTinDKSVService thongTinDKSVService;

    @GetMapping("NQL/capnhatdkpm")
    public String getCapNhatDK(HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            return "NQL/capnhatdkpm";
        }
    }

    @GetMapping("NQL/duyetgvdk")
    public String getDuyetGVDK(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("ttdkgvs", thongTinDKGVService.findByNQLUsername(user.getUsername(),0));
            model.addAttribute("ttdksvs", thongTinDKSVService.getSVMuonMayNQL(user.getUsername(), 0));
            return "NQL/duyetgvdk";
        }
    }
    @GetMapping("NQL/chitietdkgv/{id}")
    public String getChiTietDKGV(HttpSession session, @PathVariable("id") Long id, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("ttdkgv", thongTinDKGVService.findById(id));
            return "NQL/chitietdkgv";
        }
    }

    @GetMapping("/NQL/kiemtraphong/{id}")
    public String getCheckTTDK(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(id);
            if (thongTinDKGVService.checkTTDKGV(user.getPhongMay().getMaphong(), thongTinDKGV.getNgaysd(), thongTinDKGV.getGiobatdau(), 1) > 0) {
                model.addAttribute("message", "Phòng đã có người đăng ký!");
                return "/NQL/chitietdkgv/" + id;
            }
            else{
                model.addAttribute("message", "Phòng có thể đăng ký mượn!");
                return "/NQL/chitietdkgv/" + id;
            }
        }
    }
    @GetMapping("NQL/aceptTTDKGV/{id}")
    public String getAceptTTKDGV(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            ThongTinDKGV thongTinDKGV = thongTinDKGVService.findById(id);
            if (thongTinDKGVService.checkTTDKGV(user.getPhongMay().getMaphong(), thongTinDKGV.getNgaysd(), thongTinDKGV.getGiobatdau(), 1) > 0) {
                model.addAttribute("notification", "Phòng đã có người đăng ký!");
                return "/NQL/chitietdkgv/" + id;
            }
            else {
                thongTinDKGVService.aceptTTKDGV(id);
                model.addAttribute("notification", "Thành công");
                return "/NQL/chitietdkgv/" + id;
            }
        }
    }
    @GetMapping("NQL/denyTTDKGV/{id}")
    public String getDenyTTKDGV(@PathVariable("id") Long id, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            thongTinDKGVService.denyTTKDGV(id);
            model.addAttribute("notification", "Thành công");
            return "/NQL/chitietdkgv/" + id;
        }
    }

    //Sinh viên Aceptable
    @GetMapping("NQL/aceptDKSV/{id}")
    public String getAceptDKSV(@PathVariable("id") Long id, HttpSession session){
        thongTinDKSVService.aceptDKSV(id);
        return "redirect:/NQL/duyetgvdk";
    }
    @GetMapping("NQL/aceptAll")
    public String getAceptAll(HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        thongTinDKSVService.aceptAllByNQL(user.getUsername(), 0);
        return "redirect:/NQL/duyetgvdk";
    }
    @GetMapping("NQL/denyDKSV/{id}")
    public String getDenyDKSV(@PathVariable("id") Long id, HttpSession session){
        Long ttdkgvid = (Long) session.getAttribute("ttdkgvid");
        thongTinDKSVService.denyDKSV(id);
        return "redirect:/GV/duyetsvdk/"+ttdkgvid;
    }
    @GetMapping("NQL/denyAll")
    public String getDenyAll(HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        thongTinDKSVService.denyAllByNQL(user.getUsername(), 0);
        return "redirect:/NQL/duyetgvdk";
    }

    @GetMapping("NQL/reportTTDKGV")
    public String getReportTTDKGV(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("loginUser");
        if(("").equals(user) || user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("ttdkgvs", thongTinDKGVService.findByNQLUsernameToRP(user.getUsername()));
            return "NQL/reportTTDKGV";
        }
    }
}
