package com.MariaEduardaPedroza.PrjEmpresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.MariaEduardaPedroza.PrjEmpresa.entities.Departamento;
import com.MariaEduardaPedroza.PrjEmpresa.service.DepartamentoService;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	private final DepartamentoService departamentoService;
	
	 
	    public DepartamentoController(DepartamentoService departamentoService) {
	        this.departamentoService = departamentoService;
	 }
	    @PostMapping
		public Departamento createDepartamento(@RequestBody Departamento departamento) {
			return departamentoService.saveDepartamento(departamento);
		}



		@GetMapping("/{id}")
		public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depCodigo) {
			Departamento departamento = departamentoService.getDepartamentoById(depCodigo);
			if (departamento != null) {
				return ResponseEntity.ok(departamento);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/home")
		public String paginaInicial() {
			return "index";// nome do seu arquivo HTML (sem a extensão)
		}

		@DeleteMapping("/{id}")
		public void deleteDepartamento(@PathVariable Long depCodigo) {
			departamentoService.deleteDepartamento(depCodigo);
		}
		//Utilizando o ResponseEntity e RequestEntity
			@GetMapping
			public ResponseEntity<List<Departamento>> getAllDepartamentos(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Departamento> departamento = departamentoService.getAllDepartamento();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(departamento);
			}
			
			@PutMapping("/{id}")
			public Departamento updateDepartamento(@PathVariable Long depCodigo, @RequestBody Departamento departamento) {
			    return departamentoService.updateDepartamento(depCodigo, departamento);
			}


	}	 
 