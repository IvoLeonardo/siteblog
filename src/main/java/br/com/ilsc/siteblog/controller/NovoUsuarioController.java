package br.com.ilsc.siteblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("novo")
public class NovoUsuarioController {

	@GetMapping("novo-usuario")
	public String formulario() {
		return "novo/novo-usuario";
	}

	@PostMapping("novo-usuario")
	public String cadastraUsuario() {

		return "redirect:/bloghome";
	}
}
