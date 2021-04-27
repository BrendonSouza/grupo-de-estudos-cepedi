package com.universidade.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



public class ProfessorNewDTO  implements Serializable{
  private static final long serialVersionUID = 1L;

  @NotEmpty(message = "O nome do professor não pode ser vazio")
  @Length(min=5,max=120,message="O tamanho deve ser entre 5 e 120 caracteres")

  private String nome;

  @NotEmpty(message = "O Endereco do professor não pode ser vazio")
  private String endereco;
  private List<Integer> cursoId;

  @NotNull(message = "Departamento não pode ser vazio")
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
  
  public List<Integer> getCursoId() {
    return cursoId;
  }

  public void setCursoId(List<Integer> cursoId) {
    this.cursoId = cursoId;
  }

  public Integer getDepartamentoId() {
    return departamentoId;
  }
  public void setDepartamentoId(Integer departamentoId) {
    this.departamentoId = departamentoId;
  }
  

}
