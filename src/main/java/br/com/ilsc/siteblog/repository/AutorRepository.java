package br.com.ilsc.siteblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilsc.siteblog.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
