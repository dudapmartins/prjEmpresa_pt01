package com.MariaEduardaPedroza.PrjEmpresa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MariaEduardaPedroza.PrjEmpresa.entities.Funcionario;
import com.MariaEduardaPedroza.PrjEmpresa.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping("/")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long funCodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(funCodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";// nome do seu arquivo HTML (sem a extensão)
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long funCodigo) {
		funcionarioService.deleteFuncionario(funCodigo);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long funCodigo, @RequestBody Funcionario funcionario) {
		return funcionarioService.updateFuncionario(funCodigo, funcionario);
	}

}
