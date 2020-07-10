package br.com.developer.webapp.repository;

import br.com.developer.webapp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    Curso findByNome(String nome);
}
