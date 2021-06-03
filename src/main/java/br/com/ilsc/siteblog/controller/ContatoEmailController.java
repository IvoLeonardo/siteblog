package br.com.ilsc.siteblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ilsc.siteblog.dto.RequisicaoNovoContato;
import br.com.ilsc.siteblog.model.ContatoEmail;
import br.com.ilsc.siteblog.repository.ContatoEmailRepository;

@Controller
public class ContatoEmailController {

	@Autowired
	ContatoEmailRepository contatoRepository;

	@GetMapping("/contato")
	public String inicio() {

		return "contatoemail";
	}

//	@PostMapping("/salvaContato")
//	public String salvar(ContatoEmail contato) {
//
//		contatoRepository.save(contato);
//
//		return "contatoemail";
//	}

	@PostMapping("/salvaContato")
	public String salvar(RequisicaoNovoContato requisicao) {

		ContatoEmail contato = requisicao.toContato();
		contatoRepository.save(contato);
		return "redirect:/contatoemail";
	}

//	@GetMapping("/listarContatos")
//	public ModelAndView listar(ContatoEmail contato) {
//
//		Iterable<ContatoEmail> contatos = contatoRepository.findAll();
//		ModelAndView modelAndView = new ModelAndView("/listaContatosEmail");
//		modelAndView.addObject("contatos", contatos);
//
//		return modelAndView;
//	}

	@GetMapping("/listarContatos")
	public String listar(Model model) {

		Iterable<ContatoEmail> contatos = contatoRepository.findAll(PageRequest.of(0, 3, Sort.by("nome")));
		model.addAttribute("contatos", contatos);

		return "listaContatosEmail";
	}

}
