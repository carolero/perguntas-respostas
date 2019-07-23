package com.br.pergunta.resposta.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.pergunta.resposta.models.Pergunta;
import com.br.pergunta.resposta.services.PerguntaService;



@Controller
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping("/tamagotchi/cadastrar/perguntas")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cadastrar-pergunta.html");
		return modelAndView;
	}
	
	@PostMapping("/tamagotchi/cadastrar/perguntas")
	public ModelAndView cadastrarUsuario(@Valid Pergunta pergunta, BindingResult binPergunta) {
		ModelAndView modelAndView = new ModelAndView("cadastrar-pergunta.html");
		if(binPergunta.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for (ObjectError objectError : binPergunta.getAllErrors()) {
				mensagens.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
			return modelAndView;
		} else {
			modelAndView.addObject("mensagens", perguntaService.cadastrarPergunta(pergunta));
		}
		return modelAndView;
	}
	
	@GetMapping("/perguntas")
	public ModelAndView mostrarPergunta() {
		ModelAndView modelAndView = new ModelAndView("pergunta.html");
		modelAndView.addObject("pergunta", perguntaService.mostrarPerguntaAleatoria());
		return modelAndView;
	}
	
	@PostMapping("/perguntas")
	public ModelAndView capturarResposta(String resposta) {
		perguntaService.compararResposta(resposta);
		ModelAndView modelAndView = new ModelAndView("pergunta.html");
		modelAndView.addObject("pergunta", perguntaService.verificarResposta(pergunta, resposta));
		return modelAndView;
	}
	
}
