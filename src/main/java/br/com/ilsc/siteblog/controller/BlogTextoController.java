package br.com.ilsc.siteblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.repository.BlogRepository;

@Controller
public class BlogTextoController {

	@Autowired
	private BlogRepository blogRepository;

//	@GetMapping("**/textoDoBlog/{idTextoBlog}")
//	public ModelAndView mostraBlog(@PathVariable("idTextoBlog") Long id) {
//
//		Optional<Blog> blog = blogRepository.findById(id);
//
//		ModelAndView modelAndView = new ModelAndView("blogtexto");
//		modelAndView.addObject("blogObj", blog.get());
//
//		return modelAndView;
//	}

//	@GetMapping("**/textoDoBlog/{idTextoBlog}")
//	public String mostraBlog(@PathVariable("idTextoBlog") Long id, Model model) {
//
//		Optional<Blog> blog = blogRepository.findById(id);
//
//		model.addAttribute("blogObj", blog.get());
//
//		return "blogtexto";
//	}

	@GetMapping("**/textoDoBlog/{idTextoBlog}")
	public ModelAndView mostraBlog(@PathVariable("idTextoBlog") Long id) {

		ModelAndView mv = new ModelAndView("blogtexto");

		Optional<Blog> blog = blogRepository.findById(id);

		mv.addObject("blogObj", blog.get());

		return mv;
	}

	@GetMapping("editarTexto/{idTexto}")
	public ModelAndView editar(@PathVariable("idTexto") Long id) {

		Optional<Blog> blog = blogRepository.findById(id);

		ModelAndView mv = new ModelAndView("novo/blogform");
		mv.addObject("blogObj", blog.get());
//		mv.addObject("blog", blogRepository.findAll());

		return mv;
	}
}
