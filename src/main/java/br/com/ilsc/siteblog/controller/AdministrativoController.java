package br.com.ilsc.siteblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministrativoController {

	@GetMapping("administrativo")
	public String inicio() {

		return "adm/administrativo";
	}

}
