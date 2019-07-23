package com.br.pergunta.resposta.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.pergunta.resposta.models.Pergunta;

@Repository
public interface PerguntaRepository extends CrudRepository<Pergunta, Integer> {

}
