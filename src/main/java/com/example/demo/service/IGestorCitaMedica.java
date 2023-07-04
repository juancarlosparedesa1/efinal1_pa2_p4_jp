package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaMedica {
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarCitaMedica(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita);

}
