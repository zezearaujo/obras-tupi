package com.zezearaujo.controle.obras.tupi.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String email;
	
	@NotBlank
	@Size(min = 3, max = 8)
	@Column(nullable = false)
	private String senha;
	
	
	@OneToMany(mappedBy = "usuario")
	private List<Obra> obras;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}


	

}
