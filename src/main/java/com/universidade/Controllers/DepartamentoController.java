package com.universidade.Controllers;

import java.util.List;

import com.universidade.domain.Departamento;
import com.universidade.services.DepartamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {
  @Autowired
  DepartamentoService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Departamento> findDpto(@PathVariable Integer id){
    Departamento obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  } 
  @RequestMapping
  public ResponseEntity<List<Departamento>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }
}
