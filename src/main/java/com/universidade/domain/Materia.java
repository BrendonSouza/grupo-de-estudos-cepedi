package com.universidade.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class Materia  implements Serializable{
private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;  

  @NotEmpty(message = "O nome não pode ser vazio")
  @Length(min=5,max=80,message="O tamanho deve ser entre 5 e 80 caracteres")
  private String nome;
  
  @Length(min=6,max=8, message = "O tamanho do codigo da disciplina deve ser entre 6 e 8 caracteres")
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
