package br.com.ilsc.siteblog.dto;

import java.time.LocalDate;

import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.model.StatusBlog;

public class RequisicaoNovoBlog {

	private String titulo;
	private String dataPublicacao;
	private String conteudo;
	private byte[] imagem;
//	private String autor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] bs) {
		this.imagem = bs;
	}

	public Blog toBlog() {
		Blog blog = new Blog();
//		Autor autor = new Autor();
//		autor.setAutor(this.autor);

		blog.setTitulo(titulo);
		blog.setTexto(conteudo);
		blog.setStatus(StatusBlog.RASCUNHO);
		blog.setImagem(imagem);
		blog.setDataPublicacao(LocalDate.now());
//		blog.setAutor(autor);
		return blog;
	}

}
