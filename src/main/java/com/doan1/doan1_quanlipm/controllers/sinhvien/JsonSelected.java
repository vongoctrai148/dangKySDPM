package com.doan1.doan1_quanlipm.controllers.sinhvien;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.PhanMem;
import com.doan1.doan1_quanlipm.services.MayTinhService;
import com.doan1.doan1_quanlipm.services.PhanMemService;
import com.doan1.doan1_quanlipm.services.PhongMayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class JsonSelected{
    @Autowired
    private MayTinhService mayTinhService;
    @Autowired
    private PhanMemService phanMemService;

    @GetMapping("/chonphong/{phongmayId}")
    public @ResponseBody
    String getMayTinh(@PathVariable("phongmayId") String phongmayId, HttpSession session) {
        session.setAttribute("phongmayId", phongmayId);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(mayTinhService.getMayTinhByMaPhong(phongmayId));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
    @GetMapping("/chonmay/{phongmayId}")
    public @ResponseBody
    String getPhanMem(@PathVariable("phongmayId") String id, HttpSession session) {
        session.setAttribute("phongmayId", id);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(phanMemService.findPhanMemByMaPhong(id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
}
