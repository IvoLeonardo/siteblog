package br.com.ilsc.siteblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilsc.siteblog.model.Curso;
import br.com.ilsc.siteblog.repository.CursoRepository;

@Controller
@RequestMapping("novo")
public class NovoCursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping("/curso")
	public String inicio() {
		return "novo/novo-curso";
	}

	@PostMapping("/curso")
	public String salvar(Curso nome) {

		cursoRepository.save(nome);
		return "redirect:/cursos";
	}
}
