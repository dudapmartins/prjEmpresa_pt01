package com.MariaEduardaPedroza.PrjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_Departamento")

public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depCodigo;
	
	@NotNull
	@NotBlank
	@Size(max = 50, message= "Máximo de 50 caracteres")
	private String depNome;
	
	public Long getdepCodigo() {
		return depCodigo;
	}
	
	public void setdepCodigo(Long depcodigo) {
		this.depCodigo = depCodigo;
	}

	public String getdepNome() {
		return depNome;
	}

	public void setdepNome(String depNome) {
		this.depNome= depNome;	
	
}
}

	
