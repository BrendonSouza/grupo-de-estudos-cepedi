package com.universidade.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Colegiado implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;


  public Colegiado(Integer id, String nome, Curso curso) {
    this.id = id;
    this.nome = nome;
    this.curso = curso;
  }
  
  @OneToOne(mappedBy = "colegiado")
  private Curso curso;

  public Colegiado(){}


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

  
  
  
}
