package com.devsuperior.uri2990.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empregados")
public class Empregado {

	@Id
	private String cpf;
	private String enome;
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name = "cpf_supervisor")
	private Empregado supervisor;
	
	@OneToMany(mappedBy = "supervisor")
	private List<Empregado> supervisionados = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "dnumero")
	private Departamento departamento;
	
	@ManyToMany
	@JoinTable(name = "trabalha",
		joinColumns = @JoinColumn(name = "cpf_emp"),
		inverseJoinColumns = @JoinColumn(name = "pnumero"))	
	private Set<Projeto> projetosOndeTrabalha = new HashSet<>();
	
	public Empregado() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEnome() {
		return enome;
	}

	public void setEnome(String enome) {
		this.enome = enome;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Empregado getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Empregado supervisor) {
		this.supervisor = supervisor;
	}

	public List<Empregado> getSupervisionados() {
		return supervisionados;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Projeto> getProjetosOndeTrabalha() {
		return projetosOndeTrabalha;
	}
}
