package com.universidade.services;

import java.util.Arrays;
import com.universidade.domain.Colegiado;
import com.universidade.domain.Curso;
import com.universidade.domain.Departamento;
import com.universidade.domain.Materia;
import com.universidade.domain.Professor;
import com.universidade.repositories.CursoRepository;
import com.universidade.repositories.DepartamentoRepository;
import com.universidade.repositories.MateriaRepository;
import com.universidade.repositories.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
  @Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private MateriaRepository materiaRepository;
  
  public void instantiateTestDatabase() {
    Departamento dpto1= new Departamento(null,"DCET");
		Professor prof1= new Professor("Teste", "Testas", dpto1);
		Curso curso1=new Curso(null,"cic",dpto1);
		Colegiado colegiado1= new Colegiado(null,"Colcic",curso1);
		Materia materia1 = new Materia(null, "Analise de Sistema de informação", "cet352");
		dpto1.setProfessores(Arrays.asList(prof1));
		dpto1.setCursos(Arrays.asList(curso1));

		prof1.setCursos(Arrays.asList(curso1));
		curso1.getProfessores().addAll(Arrays.asList(prof1));
		curso1.setColegiado(colegiado1);
		curso1.setMaterias(Arrays.asList(materia1));
		materia1.getCursos().addAll(Arrays.asList(curso1));

		professorRepository.saveAll(Arrays.asList(prof1));
		departamentoRepository.saveAll(Arrays.asList(dpto1));
		cursoRepository.saveAll(Arrays.asList(curso1));
		materiaRepository.saveAll(Arrays.asList(materia1));

  }
}
