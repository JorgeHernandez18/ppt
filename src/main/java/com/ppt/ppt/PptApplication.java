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
		/*ActividadPA actividadPA = new ActividadPA();
		actividadPA.setNombre("actividad prueba");
		actividadPA.setFecha_inicio("2023-06-10");
		actividadPA.setFecha_fin("2023-06-14");
		actividadPA.setProyecto_aula(2);
		actividadPA.setCumplimiento((byte) 1);
		actividadPA.setObservacion("observacion");

		Estudiante e = new Estudiante();
		e.setCodigo(1151810);
		e.setNombre("Juan");
		e.setApellido("Garcia");
		e.setCorreo_electronico("juano@gmail.com");

		Set<Estudiante_Apoyo> ea = new HashSet<>();
		Estudiante_Apoyo estudiante_apoyo = new Estudiante_Apoyo();
		estudiante_apoyo.setEstudiante(e);
		estudiante_apoyo.setActividadPA(actividadPA);

		ea.add(estudiante_apoyo);
		ActividadPA acti = actividadPADao.createActividadPA(actividadPA, ea);
		System.out.println(acti.getNombre());*/


	}
}
