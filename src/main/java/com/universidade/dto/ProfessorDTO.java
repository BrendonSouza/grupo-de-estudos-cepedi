package com.universidade.dto;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


import com.universidade.domain.Curso;
import com.universidade.domain.Professor;



public class ProfessorDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private String endereco;
  private List<Integer> cursosId;

  public ProfessorDTO(){}

  public ProfessorDTO(Professor obj) {
    this.id=obj.getId();
    this.nome = obj.getNome();
    this.endereco = obj.getEndereco();
    this.cursosId=getCursosID(obj.getCursos());
  }

  public List<Integer>getCursosID(List<Curso> cursos){
    List<Integer> cursosID=new ArrayList<>();
    cursos.forEach((curso)->cursosID.add(curso.getId()));
    return cursosID;
  }
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public List<Integer> getCursosId() {
    return cursosId;
  }

  public void setCursos(List<Integer> cursos) {
    this.cursosId = cursos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  
}
