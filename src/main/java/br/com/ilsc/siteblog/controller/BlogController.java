package br.com.ilsc.siteblog.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.model.StatusBlog;
import br.com.ilsc.siteblog.repository.BlogRepository;

@Controller
@RequestMapping("/bloghome")
public class BlogController {

	@Autowired
	private BlogRepository blogRepository;

	@GetMapping
	public String blog(Model model, Principal principal) {

		Sort sort = Sort.by("dataPublicacao").descending();
		PageRequest paginacao = PageRequest.of(0, 20, sort);

		List<Blog> blogs = blogRepository.findByStatus(StatusBlog.POSTADO, paginacao);
		model.addAttribute("blogs", blogs);
		return "bloghome";
	}
}
