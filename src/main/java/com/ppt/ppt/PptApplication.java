package com.ppt.ppt;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.dao.Estudiante_ApoyoDao;
import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Estudiante_Apoyo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PptApplication implements CommandLineRunner {

	@Autowired
	private ActividadPADao actividadPADao;
	public static void main(String[] args) {
		SpringApplication.run(PptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
