package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica citamed = this.buscar(id);
		this.entityManager.remove(citamed);

	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		Query myQuery = this.entityManager
				.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.numeroCita=:datoNumeroCita");
		myQuery.setParameter("datoNumeroCita", numeroCita);

		return (CitaMedica) myQuery.getSingleResult();
	}

}
