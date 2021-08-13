package com.doan1.doan1_quanlipm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
public class Doan1QuanlipmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Doan1QuanlipmApplication.class, args);
		System.out.println("Đã load xong!");
	}
}
