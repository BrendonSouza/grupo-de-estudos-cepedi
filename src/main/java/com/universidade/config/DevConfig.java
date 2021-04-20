package com.universidade.config;

import java.text.ParseException;

import com.universidade.services.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
  @Autowired
  private DBService dbService;

  @Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

  @Bean
  public boolean instantiateDatabase() throws ParseException{
    //chamando a instanciação que está na classe de servico
    if(!"create".equals(strategy)){
      return false;
    }

    dbService.instantiateTestDatabase();

    return true;
  }
}
