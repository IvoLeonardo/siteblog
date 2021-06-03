package br.com.ilsc.siteblog.dto;

import br.com.ilsc.siteblog.model.ContatoEmail;

public class RequisicaoNovoContato {

	private String nome;
	private String email;
	private String whatsapp;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public ContatoEmail toContato() {

		ContatoEmail contato = new ContatoEmail();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setWhatsApp(whatsapp);
		return contato;
	}
}
