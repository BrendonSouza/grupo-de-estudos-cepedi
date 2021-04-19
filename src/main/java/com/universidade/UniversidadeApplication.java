package com.universidade;

import java.util.Arrays;

import com.universidade.domain.Colegiado;
import com.universidade.domain.Curso;
import com.universidade.domain.Departamento;
import com.universidade.domain.Professor;
import com.universidade.repositories.CursoRepository;
import com.universidade.repositories.DepartamentoRepository;
import com.universidade.repositories.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversidadeApplication implements CommandLineRunner {

	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	public static void main(String[] args) {
		SpringApplication.run(UniversidadeApplication.class, args);
	}

	@Override
	public void run(String... args){
		Departamento dpto1= new Departamento(null,"DCET");
		Professor prof1= new Professor("Teste", "Testas", dpto1);
		Curso curso1=new Curso(null,"cic",dpto1);
		Colegiado colegiado1= new Colegiado(null,"Colcic",curso1);

		dpto1.setProfessores(Arrays.asList(prof1));
		dpto1.setCursos(Arrays.asList(curso1));

		prof1.setCursos(Arrays.asList(curso1));
		curso1.setProfessores(Arrays.asList(prof1));
		curso1.setColegiado(colegiado1);


		professorRepository.saveAll(Arrays.asList(prof1));
		departamentoRepository.saveAll(Arrays.asList(dpto1));
		cursoRepository.saveAll(Arrays.asList(curso1));
		



	}

}
