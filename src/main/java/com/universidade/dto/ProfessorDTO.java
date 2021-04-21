package com.universidade.dto;

import java.io.Serializable;



public class ProfessorDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  private String nome;
  private String endereco;


  public ProfessorDTO(){}

  public ProfessorDTO(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
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
  
}
