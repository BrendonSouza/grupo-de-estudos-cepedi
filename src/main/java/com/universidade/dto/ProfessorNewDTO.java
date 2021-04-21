package com.universidade.dto;

import java.io.Serializable;

public class ProfessorNewDTO  implements Serializable{
  private static final long serialVersionUID = 1L;

  private String nome;
  private String endereco;
  private Integer cursoId;
  private Integer departamentoId;

  public ProfessorNewDTO(){}

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
  public Integer getCursoId() {
    return cursoId;
  }
  public void setCursoId(Integer cursoId) {
    this.cursoId = cursoId;
  }
  public Integer getDepartamentoId() {
    return departamentoId;
  }
  public void setDepartamentoId(Integer departamentoId) {
    this.departamentoId = departamentoId;
  }
  

}
