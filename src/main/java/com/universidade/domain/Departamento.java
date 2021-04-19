package com.universidade.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Departamento implements Serializable{
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private List<Professor> professores;
  private List<Curso> cursos;
  
  public Departamento(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }

  public List<Curso> getCursos() {
    return cursos;
  }

  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }
  


  
}
