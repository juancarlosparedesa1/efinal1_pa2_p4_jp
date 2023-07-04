package com.example.demo.service;

import com.example.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaService {
	public void ingresar(CitaMedica cita);

	public CitaMedica buscar(Integer id);

	public void actualizar(CitaMedica cita);

	public void borrar(Integer id);

	public CitaMedica buscarPorNumero(String numeroCita);
}
