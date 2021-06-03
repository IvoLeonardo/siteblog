package br.com.ilsc.siteblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ilsc.siteblog.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
