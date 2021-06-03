package br.com.ilsc.siteblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilsc.siteblog.model.Autor;
import br.com.ilsc.siteblog.repository.AutorRepository;

@Controller
@RequestMapping("/novo")
public class NovoAutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping("/novoAutor")
	public String inicio() {

		return "novo/novoAutor";
	}

	@PostMapping("/salvarAutor")
	public String salvar(Autor autor) {

		autorRepository.save(autor);

		return "redirect:/novo/novoAutor";
	}
}
