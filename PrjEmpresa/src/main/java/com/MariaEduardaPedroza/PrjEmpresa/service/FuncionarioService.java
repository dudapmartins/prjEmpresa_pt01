package com.MariaEduardaPedroza.PrjEmpresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaEduardaPedroza.PrjEmpresa.entities.Departamento;
import com.MariaEduardaPedroza.PrjEmpresa.entities.Funcionario;
import com.MariaEduardaPedroza.PrjEmpresa.repository.DepartamentoRespository;
import com.MariaEduardaPedroza.PrjEmpresa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario saveFuncionario (Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario getFuncionarioById(Long funCodigo) {
		return funcionarioRepository.findById(funCodigo).orElse(null);

	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	public void deleteFuncionario(Long funCodigo) {
		funcionarioRepository.deleteById(funCodigo);
	}

	// fazendo o update do jogo com o optional
	public Funcionario updateFuncionario(Long funCodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funCodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunNome(novoFuncionario.getFunNome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunSalario(novoFuncionario.getFunSalario());
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}
	

}
