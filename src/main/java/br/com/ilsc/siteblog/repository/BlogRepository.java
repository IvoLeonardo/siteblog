package br.com.ilsc.siteblog.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ilsc.siteblog.model.Blog;
import br.com.ilsc.siteblog.model.StatusBlog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

	@Cacheable("books")
	List<Blog> findByStatus(StatusBlog status, Pageable sort);

	@Query("select b from Blog b join b.user u where u.username = :username")
	List<Blog> findAllByUsuario(@Param("username") String username);

	@Query("select b from Blog b join b.user u where u.username = :username and b.status = :status")
	List<Blog> findByStatusEUsuario(@Param("status") StatusBlog status, @Param("username") String username);

}
