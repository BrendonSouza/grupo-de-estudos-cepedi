package com.universidade.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Materia  implements Serializable{
private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;  

  private String nome;
  private String codigo;
  
  @ManyToMany(mappedBy = "materias")
  private List<Curso> cursos= new ArrayList<>();
  
  public Materia(){}
  public Materia(Integer id, String nome, String codigo) {
    this.id = id;
    this.nome = nome;
    this.codigo = codigo;
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

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public List<Curso> getCursos() {
    return cursos;
  }
  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }


  
  
}
