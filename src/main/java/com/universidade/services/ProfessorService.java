package com.universidade.services;

import java.util.List;
import java.util.Optional;


import com.universidade.domain.Departamento;
import com.universidade.domain.Professor;
import com.universidade.dto.ProfessorNewDTO;

import com.universidade.repositories.DepartamentoRepository;
import com.universidade.repositories.ProfessorRepository;
import com.universidade.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
  @Autowired
  private ProfessorRepository professorRepository;
  @Autowired
  private DepartamentoRepository departamentoRepository;
  // @Autowired
  // private CursoRepository cursoRepository;
  public Professor find(Integer id) {
    Optional<Professor> obj = professorRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Professor não encontrado cara! Id: " + id + ", Tipo: " + Professor.class.getName()));
  }

  public List<Professor> findAll(){
    return professorRepository.findAll();
  }

  public Professor insert(Professor obj){
    obj.setId(null);
    obj=professorRepository.save(obj);
    System.out.println(obj);
    return obj;
  }

  public Professor fromDTO(ProfessorNewDTO objDTO){
    Optional<Departamento> depto=departamentoRepository.findById(objDTO.getDepartamentoId());
    // Optional<Curso> curso=cursoRepository.findById(objDTO.getCursoId());
    Departamento dpt=depto.orElseThrow(() -> new ObjectNotFoundException(
      "Departamento não cadastrado!"));

    Professor prof= new Professor(objDTO.getNome(), objDTO.getEndereco(), dpt);
    return prof;
  }

  public void delete(Integer id) {
    find(id);
    departamentoRepository.deleteById(id);

  }




}
