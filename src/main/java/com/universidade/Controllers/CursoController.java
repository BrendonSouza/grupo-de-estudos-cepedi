package com.universidade.Controllers;

import java.net.URI;
import java.util.List;

import com.universidade.domain.Curso;
import com.universidade.dto.CursoNewDTO;
import com.universidade.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
  @Autowired
  CursoService service;
  //show
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Curso> findDpto(@PathVariable Integer id){
    Curso obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  } 
  //index
  @RequestMapping
  public ResponseEntity<List<Curso>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }
  //create & store
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody  CursoNewDTO objDTO){
    Curso obj=service.fromDTO(objDTO);
    obj=service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
