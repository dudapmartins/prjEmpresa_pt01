package com.MariaEduardaPedroza.PrjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_Funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funCodigo;
	
	@NotNull
	@NotBlank
	@Size(max = 100, message= "Máximo de 100 caracteres")
	private String funNome;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;
	

	private Double funSalario;

	public Long getFunCodigo() {
		return funCodigo;
	}

	public void setFunCodigo(Long funCodigo) {
		this.funCodigo = funCodigo;
	}

	public String getFunNome() {
		return funNome;
	}

	public void setFunNome(String funNome) {
		this.funNome = funNome;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public Long getFunSalario() {
		return funSalario;
	}

	public void setFunSalario(Double funSalario) {
		this.funSalario = funSalario;
	}
	
	//get e set

}
