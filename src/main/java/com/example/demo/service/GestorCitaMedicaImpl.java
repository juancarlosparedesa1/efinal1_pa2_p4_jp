package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

@Service
public class GestorCitaMedicaImpl implements IGestorCitaMedica {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Override
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Doctor doctorbd = this.doctorService.buscarPorCedulaDoctor(cedulaDoctor);

		Paciente pacientebd = this.pacienteService.buscarPorCedulaPaciente(cedulaPaciente);

		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setDiagnotico("fractura");
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setFechaProximaCita(LocalDateTime.of(2023, 8, 10, 10, 0));
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setNumeroCita(numeroCita);
		citaMedica.setReceta("Paracetamol 600mg");
		citaMedica.setValorCita(valorCita);
		citaMedica.setDoctor(doctorbd);
		citaMedica.setPaciente(pacientebd);
		this.citaMedicaService.ingresar(citaMedica);

	}

	@Override
	public void actualizarCitaMedica(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica citaMedicabd = this.citaMedicaService.buscarPorNumero(numeroCita);

		citaMedicabd.setDiagnotico(diagnostico);
		citaMedicabd.setReceta(receta);
		citaMedicabd.setFechaProximaCita(fechaProximaCita);
		this.citaMedicaService.actualizar(citaMedicabd);

	}

}
