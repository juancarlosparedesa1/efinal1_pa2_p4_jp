package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICitaMedicaRepository;
import com.example.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void ingresar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.insertar(cita);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.buscar(id);
	}

	@Override
	public void actualizar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizar(cita);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.eliminar(id);

	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.buscarPorNumero(numeroCita);
	}

}
