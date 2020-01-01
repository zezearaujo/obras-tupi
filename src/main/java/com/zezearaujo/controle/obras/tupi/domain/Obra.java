package com.zezearaujo.controle.obras.tupi.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "OBRAS")
public class Obra extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String cliente;
	
	@NotBlank
	@Size(max = 50, min = 3)
	@Column(name="numero_obra", nullable = false, unique = true)
	private String numeroObra;
	
	@Size(max = 11)
	@Column(nullable = true, unique = true)
	private String telefone;
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String solicitante;
	
	@Size(max = 255, min = 3)
	private String promotor;
	
	@Size(max = 100)
	private String email;
	
	@Size(max = 10)
	private String placa;
	
	@Size(max = 100)
	private String regiao;
	
	@NotBlank
	@Size(max = 11)
	@Column(name = "telefone_solicitante", nullable = false)
	private String telefoneSolicitante;
	

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_cadastro",  nullable = false, columnDefinition = "DATE")
	private LocalDate dataCadastro;
	
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private SituacaoObra situacao;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@NotNull(message = "{NotNull.obra.usuario}")
	@ManyToOne
	@JoinColumn(name = "usuario_id_fk")
	private Usuario usuario;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumeroObra() {
		return numeroObra;
	}

	public void setNumeroObra(String numeroObra) {
		this.numeroObra = numeroObra;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getPromotor() {
		return promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}



	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTelefoneSolicitante() {
		return telefoneSolicitante;
	}

	public void setTelefoneSolicitante(String telefoneSolicitante) {
		this.telefoneSolicitante = telefoneSolicitante;
	}

	public SituacaoObra getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoObra situacao) {
		this.situacao = situacao;
	}

	
}
