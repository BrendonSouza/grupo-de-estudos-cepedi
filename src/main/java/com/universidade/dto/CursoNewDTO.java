package com.universidade.dto;

import java.io.Serializable;


public class CursoNewDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  private String nome;
  private Integer departamentoId;
  private String nomeColegiado;


  public CursoNewDTO(){}

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getDepartamentoId() {
    return departamentoId;
  }

  public void setDepartamentoId(Integer departamentoId) {
    this.departamentoId = departamentoId;
  }

  public String getNomeColegiado() {
    return nomeColegiado;
  }

  public void setNomeColegiado(String nomeColegiado) {
    this.nomeColegiado = nomeColegiado;
  }


  

}
