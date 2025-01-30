package br.cassol.centerlar.repositories;

import br.cassol.centerlar.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
