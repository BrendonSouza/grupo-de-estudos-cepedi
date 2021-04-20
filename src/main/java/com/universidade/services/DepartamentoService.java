package com.universidade.services;

import java.util.List;
import java.util.Optional;

import com.universidade.domain.Departamento;
import com.universidade.repositories.DepartamentoRepository;
import com.universidade.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {
  @Autowired
  DepartamentoRepository departamentoRepository;

  public Departamento find(Integer id) {
    Optional<Departamento> obj = departamentoRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Departamento não encontrado cara! Id: " + id + ", Tipo: " + Departamento.class.getName()));
  }

  public List<Departamento> findAll(){
    return departamentoRepository.findAll();
  }


}
