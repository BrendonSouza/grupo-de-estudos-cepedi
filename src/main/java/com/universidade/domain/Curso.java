package com.universidade.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Curso implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //validar nome

  @NotEmpty(message = "Nome não pode ser vazio")
  private String nome;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Departamento departamento;


  @JsonIgnore
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "CURSO_MATERIA", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "materia_id"))
  private List<Materia> materias= new ArrayList<>();

  @JsonIgnore
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "CURSO_PROFESSOR", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
  private List<Professor> professores=new ArrayList<>();

  @OneToOne(cascade= CascadeType.ALL)
  @JoinColumn(name="colegiado_id",referencedColumnName = "id")
  private Colegiado colegiado;


  public Curso(){}

  public Curso(Integer id, String nome, Departamento departamento) {
    this.id = id;
    this.nome = nome;
    this.departamento = departamento;
  }



  public Colegiado getColegiado() {
    return colegiado;
  }

  public void setColegiado(Colegiado colegiado) {
    this.colegiado = colegiado;
  }



  public List<Materia> getMaterias() {
    return materias;
  }

  public void setMaterias(List<Materia> materias) {
    this.materias = materias;
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

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public List<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }
  
  
}
