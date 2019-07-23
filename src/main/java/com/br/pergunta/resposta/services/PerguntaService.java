package com.br.pergunta.resposta.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pergunta.resposta.models.Pergunta;
import com.br.pergunta.resposta.repositories.PerguntaRepository;


@Service
public class PerguntaService {
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	public String cadastrarPergunta(Pergunta pergunta) {
		perguntaRepository.save(pergunta);
		return "Cadastro realizado com sucesso";
	}
	
	public Pergunta mostrarPerguntaAleatoria() {
		Random random = new Random();
		int numeroGerado = random.nextInt(3)+1;
		return perguntaRepository.findById(numeroGerado).get();
	}
	
	public String compararResposta(Pergunta pergunta, String resposta) {
		
	}

}
