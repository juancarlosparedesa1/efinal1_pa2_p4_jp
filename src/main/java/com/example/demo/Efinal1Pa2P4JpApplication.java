package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IGestorCitaMedica;
import com.example.demo.service.IPacienteService;

@SpringBootApplication
public class Efinal1Pa2P4JpApplication implements CommandLineRunner {

	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IGestorCitaMedica gestorCitaMedica;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4JpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		1. Funcionalidad CRUD para Doctor
//		Nota: desde la clase principal debe ejecutarse el ingreso de 1 Doctor

		Doctor doctor1 = new Doctor();
		doctor1.setApellido("Paredes");
		doctor1.setCedula("1726890000");
		doctor1.setCodigoSenecyt("0001");
		doctor1.setFechaNacimiento(LocalDateTime.of(1999, 5, 5, 5, 5));
		doctor1.setGenero("M");
		doctor1.setNombre("Juan carlos");
		doctor1.setNumeroConsultorio("2004");
		this.doctorService.ingresar(doctor1);

//		2. Funcionalidad Ingresar y Actualizar Paciente
//		Nota: desde la clase principal debe ejecutarse el ingreso de 1 Paciente
		Paciente paciente1 = new Paciente();
		paciente1.setApellido("Angulo");
		paciente1.setCedula("0400725000");
		paciente1.setCodigoSeguro("00000001");
		paciente1.setEstatura(1.65f);
		paciente1.setFechaNacimiento(LocalDateTime.of(1963, 4, 4, 4, 4));
		paciente1.setGenero("F");
		paciente1.setNombre("Alicia");
		paciente1.setPeso(50.5f);
		this.pacienteService.ingresar(paciente1);

//		3. Funcionalidad agendamiento cita medica
//		Nota: desde la clase principal debe ejecutarse esta funcionalidad únicamente con los 6
//		argumentos necesarios (Número de cita, Fecha cita, Valor cita, Lugar cita, Cedula doctor, 
//		Cedula paciente) y con los datos utilizados en el punto 1 y 2
		this.gestorCitaMedica.agendarCita("A-001", LocalDateTime.of(2023, 7, 7, 14, 0), new BigDecimal(20),
				"Quito Norte", doctor1.getCedula(), paciente1.getCedula());

//		4. Funcionalidad actualización cita medica
//		Nota: desde la clase principal debe ejecutarse esta funcionalidad únicamente con los 4
//		argumentos necesarios (Número de cita, Diagnóstico, Receta y Fecha próxima cita).

		this.gestorCitaMedica.actualizarCitaMedica("A-001", "Contusion", "Comprimidos 100mg",
				LocalDateTime.of(2023, 10, 10, 15, 0));

	}

}
