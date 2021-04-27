package com.universidade.repositories;



import com.universidade.domain.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer>{
  
  @Transactional(readOnly= true)
  Curso findByNome(String nome);
}
