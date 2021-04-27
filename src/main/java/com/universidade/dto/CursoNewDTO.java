package com.universidade.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.universidade.validations.CursoInsert;

import org.hibernate.validator.constraints.Length;

@CursoInsert
public class CursoNewDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  @NotEmpty(message = "Nome nao pode ser nulo")
  @Length(min=5,max=80,message="O tamanho deve ser entre 5 e 80 caracteres")

  private String nome;
  @NotNull(message = "departamento não pode ser nulo")
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
