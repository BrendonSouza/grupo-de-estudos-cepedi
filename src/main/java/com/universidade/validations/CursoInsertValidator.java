package com.universidade.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.universidade.Controllers.exceptions.FieldMessage;
import com.universidade.domain.Curso;
import com.universidade.dto.CursoNewDTO;
import com.universidade.repositories.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CursoInsertValidator implements ConstraintValidator<CursoInsert,CursoNewDTO> {
  @Autowired
  CursoRepository cursoRepository;

  @Override
	public void initialize(CursoInsert ann) {
	}

  @Override
	public boolean isValid(CursoNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

   
		
		Curso aux= cursoRepository.findByNome(objDto.getNome());
		if(aux!=null){
			list.add(new FieldMessage("nome", "curso já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

