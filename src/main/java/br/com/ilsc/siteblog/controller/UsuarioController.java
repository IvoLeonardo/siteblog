package br.com.ilsc.siteblog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.model.StatusBlog;
import br.com.ilsc.siteblog.repository.BlogRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private BlogRepository blogRepository;

	@GetMapping("blogs")
	public String entrarBlog(Model model, Principal principal) {

		Iterable<Blog> blogs = blogRepository.findAllByUsuario(principal.getName());
		model.addAttribute("blogs", blogs);
		return "usuario/blog-home-usuario";
	}

	@GetMapping("blogs/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {

		Iterable<Blog> blogs = blogRepository.findByStatusEUsuario(StatusBlog.valueOf(status.toUpperCase()),
				principal.getName());

		model.addAttribute("blogs", blogs);
		model.addAttribute("status", status);
		return "usuario/blog-home-usuario";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/blog-home-usuario";
	}
}
