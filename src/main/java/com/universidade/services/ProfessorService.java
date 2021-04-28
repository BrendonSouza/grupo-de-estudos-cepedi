package com.universidade.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.universidade.domain.Curso;
import com.universidade.domain.Departamento;
import com.universidade.domain.Professor;
import com.universidade.dto.ProfessorDTO;
import com.universidade.dto.ProfessorNewDTO;
import com.universidade.repositories.CursoRepository;
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

  @Autowired
  private CursoRepository cursoRepository;

  public Professor find(Integer id) {
    if(id==null||id<1)
      throw new IllegalArgumentException("O Id Informado é inválido: "+id);
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

    Professor prof= new Professor(null,objDTO.getNome(), objDTO.getEndereco(), dpt);
    return prof;
  }

  public void delete(Integer id) {
    find(id);
    departamentoRepository.deleteById(id);

  }
  
  public Professor fromDTO(ProfessorDTO objDTO){
    Professor prof=new Professor(objDTO.getId(), objDTO.getNome(),objDTO.getEndereco(),null);
    prof.getCursos().addAll(cursoRepository.findAllById(objDTO.getCursosId()));
    return prof;
 }

  public Professor update(Professor obj){
    Professor newObj=find(obj.getId());
    updateData(newObj, obj);
    return professorRepository.save(obj);
  }

  private void updateData(Professor newObj, Professor obj) {
    newObj.setNome(obj.getNome());
    newObj.setEndereco(obj.getEndereco());
    newObj.setDepartamento(obj.getDepartamento());
    List<Curso> cursos = obj.getCursos(); 
    cursos.forEach((curso)->curso.getProfessores().addAll(Arrays.asList(newObj)));
   
  }




}
