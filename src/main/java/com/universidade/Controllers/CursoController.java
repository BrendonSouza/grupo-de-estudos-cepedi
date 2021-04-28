package com.universidade.Controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.universidade.domain.Curso;
import com.universidade.dto.CursoNewDTO;
import com.universidade.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
  @Autowired
  CursoService service;
  //show
  @GetMapping(value = "/{id}")
  public ResponseEntity<Curso> findDpto(@PathVariable Integer id){
    Curso obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  } 
  //index
  @GetMapping
  public ResponseEntity<List<Curso>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }
  //create & store
  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody  CursoNewDTO objDTO){
    Curso obj=service.fromDTO(objDTO);
    obj=service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
