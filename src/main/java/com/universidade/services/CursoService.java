package com.universidade.services;

import java.util.List;
import java.util.Optional;


import com.universidade.domain.Departamento;
import com.universidade.dto.CursoNewDTO;
import com.universidade.domain.Colegiado;
import com.universidade.domain.Curso;

import com.universidade.repositories.DepartamentoRepository;
import com.universidade.repositories.ColegiadoRepository;
import com.universidade.repositories.CursoRepository;
import com.universidade.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
  @Autowired
  private CursoRepository cursoRepository;
  @Autowired
  private DepartamentoRepository departamentoRepository;
  @Autowired
  private ColegiadoRepository colegiadoRepository;
  // @Autowired
  // private CursoRepository cursoRepository;
  public Curso find(Integer id) {
    if(id==null||id<=0)
      throw new IllegalArgumentException("O Id Informado é inválido: "+id);
    Optional<Curso> obj = cursoRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Curso não encontrado cara! Id: " + id + ", Tipo: " + Curso.class.getName()));
  }

  public List<Curso> findAll(){
    return cursoRepository.findAll();
  }

  public Curso insert(Curso obj){
    obj.setId(null);
    obj=cursoRepository.save(obj);
    colegiadoRepository.save(obj.getColegiado());
    return obj;
  }

  //verificar id colegiado
  public Curso fromDTO(CursoNewDTO objDTO){
    Optional<Departamento> depto=departamentoRepository.findById(objDTO.getDepartamentoId());
    Departamento dpt=depto.orElseThrow(() -> new ObjectNotFoundException(
      "Departamento não cadastrado!"));

    Curso curso= new Curso(null,objDTO.getNome(), dpt);
    Colegiado colegiado = new Colegiado(null,objDTO.getNomeColegiado(),curso);
    curso.setColegiado(colegiado);
    return curso;
  }

  public void delete(Integer id) {
    find(id);
    departamentoRepository.deleteById(id);

  }




}
