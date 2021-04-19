package com.universidade.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable{
  private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @OneToMany(mappedBy = "departamento", cascade=CascadeType.ALL)
  private List<Professor> professores = new ArrayList<>();
  
  @OneToMany(mappedBy = "departamento", cascade=CascadeType.ALL)
  private List<Curso> cursos;
    
  public List<Curso> getCursos() {
    return cursos;
  }
  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }
  public Departamento(){}
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

  // public List<Curso> getCursos() {
  //   return cursos;
  // }

  // public void setCursos(List<Curso> cursos) {
  //   this.cursos = cursos;
  // }
  


  
}
