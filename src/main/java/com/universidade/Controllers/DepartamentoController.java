package com.universidade.Controllers;

import java.net.URI;
import java.util.List;

import com.universidade.domain.Departamento;
import com.universidade.services.DepartamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {
  @Autowired
  DepartamentoService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Departamento> findDpto(@PathVariable Integer id){
    Departamento obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  } 

  @GetMapping
  public ResponseEntity<List<Departamento>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody  Departamento obj){
    obj=service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
