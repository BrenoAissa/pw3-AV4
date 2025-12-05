package br.edu.ifsp.prw3.avaliacao4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport; // Import necessário

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO) // Adicionar esta anotação
public class Avaliacao4Application {

    public static void main(String[] args) {
        SpringApplication.run(Avaliacao4Application.class, args);
    }

}