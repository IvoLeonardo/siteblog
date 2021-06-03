package br.com.ilsc.siteblog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ilsc.siteblog.dto.RequisicaoNovoBlog;
import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.model.User;
import br.com.ilsc.siteblog.repository.BlogRepository;
import br.com.ilsc.siteblog.repository.UserRepository;

@Controller
@RequestMapping("novo")
public class NovoBlogController {

	// Alura Spring MVC
	// Aula 04 Trabalhando com formulário
	// Atividade 03 Formulário pedido
	// Atividade 04 Salvando pedido

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
//	private AutorRepository autorRepository;

	@GetMapping("formulario")
	public ModelAndView formulario() {

		ModelAndView mv = new ModelAndView("novo/blogform");
		mv.addObject("blogObj", new Blog());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "blogform")
	public String blog(RequisicaoNovoBlog requisicao) throws IOException {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepository.findByUsername(username);

		Blog blog = requisicao.toBlog();

		blog.setUser(user);

		blogRepository.save(blog);
		return "redirect:/bloghome";
	}

//	@RequestMapping(method = RequestMethod.POST, value = "blogform", consumes = { "multipart/form-data" })
//	public String blog(RequisicaoNovoBlog requisicao, @RequestParam("fileImagem") MultipartFile file)
//			throws IOException {
//
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		User user = userRepository.findByUsername(username);
//
//
//		Blog blog = requisicao.toBlog();
//
//		if (file.getSize() > 0) {
//			requisicao.setImagem(file.getBytes());
//		} else {
//			byte[] imagemTemp = blogRepository.findById(blog.getId()).get().getImagem();
//			blog.setImagem(imagemTemp);
//		}
//
//		blog.setUser(user);
//
//		blogRepository.save(blog);
//		return "redirect:/bloghome";
//	}

//	@RequestMapping(method = RequestMethod.POST, value = "blogform", consumes = { "multipart/form-data" })
//	public String blog(RequisicaoNovoBlog requisicao, @RequestParam("fileImagem") MultipartFile file)
//			throws IOException {
//
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		User user = userRepository.findByUsername(username);
//
//		requisicao.setImagem(file.getBytes());
//
//		Blog blog = requisicao.toBlog();
//
//		blog.setUser(user);
//
//		blogRepository.save(blog);
//		return "redirect:/bloghome";
//	}

//	@GetMapping("/imagem{idImagem}")
//	@ResponseBody
//	public byte[] exibirImagem(@PathVariable("idImagem") Long idBlog) {
//		Blog blog = this.blogRepository.getOne(idBlog);
//
//		return blog.getImagem();
//	}
}
