package com.universidade.repositories;

import com.universidade.domain.Colegiado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegiadoRepository extends JpaRepository<Colegiado,Integer> {
  
}
