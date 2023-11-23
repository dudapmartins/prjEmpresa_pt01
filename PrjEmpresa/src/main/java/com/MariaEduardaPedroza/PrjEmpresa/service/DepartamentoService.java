package com.MariaEduardaPedroza.PrjEmpresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaEduardaPedroza.PrjEmpresa.entities.Departamento;
import com.MariaEduardaPedroza.PrjEmpresa.repository.DepartamentoRespository;




@Service
public class DepartamentoService {

	private final DepartamentoRespository departamentoRepository;
	@Autowired
	public DepartamentoService(DepartamentoRespository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public Departamento saveDepartamento (Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public Departamento getDepartamentoById(Long depCodigo) {
		return departamentoRepository.findById(depCodigo).orElse(null);

	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public void deleteDepartamento(Long depCodigo) {
		departamentoRepository.deleteById(depCodigo);
	}

	// fazendo o update do jogo com o optional
	public Departamento updateDepartamento(Long depCodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depCodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setdepNome(novoDepartamento.getdepNome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
	
}
