package com.devsuperior.uri2990.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	private Long dnumero;
	private String dnome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Empregado> empregados = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "cpf_gerente")
	private Empregado gerente;
	
	public Departamento() {
	}

	public Long getDnumero() {
		return dnumero;
	}

	public void setDnumero(Long dnumero) {
		this.dnumero = dnumero;
	}

	public String getDnome() {
		return dnome;
	}

	public void setDnome(String dnome) {
		this.dnome = dnome;
	}

	public Empregado getGerente() {
		return gerente;
	}

	public void setGerente(Empregado gerente) {
		this.gerente = gerente;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}
}
