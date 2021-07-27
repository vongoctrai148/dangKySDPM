package com.doan1.doan1_quanlipm;

import com.doan1.doan1_quanlipm.entities.MayTinh;
import com.doan1.doan1_quanlipm.entities.PhanMem;
import com.doan1.doan1_quanlipm.entities.PhongMay;
import com.doan1.doan1_quanlipm.services.PhongMayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class Doan1QuanlipmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Doan1QuanlipmApplication.class, args);
		System.out.println("Đã load xong!");
	}

}
