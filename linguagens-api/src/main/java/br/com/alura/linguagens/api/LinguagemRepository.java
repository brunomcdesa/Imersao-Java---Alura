package br.com.alura.linguagens.api;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository <Linguagem, String> {


    
}
