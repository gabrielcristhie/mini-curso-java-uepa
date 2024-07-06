package com.curso.java.DTO;

import java.util.List;

import com.curso.java.entities.Alunos;


public class MateriaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private List<Alunos> alunos;

	public MateriaDTO() {
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Alunos> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
    
    
}
