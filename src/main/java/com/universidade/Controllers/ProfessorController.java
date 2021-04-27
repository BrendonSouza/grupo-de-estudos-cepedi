package com.universidade.Controllers;

import java.net.URI;
import java.util.List;

import com.universidade.domain.Professor;
import com.universidade.dto.ProfessorDTO;
import com.universidade.dto.ProfessorNewDTO;
import com.universidade.services.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
  @Autowired
  ProfessorService service;
  //show
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Professor> findDpto(@PathVariable Integer id){
    Professor obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  } 
  //index
  @RequestMapping
  public ResponseEntity<List<Professor>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }
  //create & store
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody  ProfessorNewDTO objDT){
    Professor obj=service.fromDTO(objDT);
    obj=service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)

  public ResponseEntity<Void> update(@RequestBody ProfessorDTO objDTO, @PathVariable Integer id) {
    Professor obj = service.fromDTO(objDTO);
    obj.setId(id);
    obj = service.update(obj);
    return ResponseEntity.noContent().build();

  }
  
  
}
