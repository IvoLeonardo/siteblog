package br.com.ilsc.siteblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilsc.siteblog.model.ContatoEmail;

@Repository
public interface ContatoEmailRepository extends JpaRepository<ContatoEmail, Long> {

}
