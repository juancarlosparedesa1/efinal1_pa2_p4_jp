package com.example.demo.repository;

import com.example.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	public void insertar(CitaMedica citaMedica);

	public CitaMedica buscar(Integer id);

	public void actualizar(CitaMedica citaMedica);

	public void eliminar(Integer id);

	public CitaMedica buscarPorNumero(String numeroCita);
}
