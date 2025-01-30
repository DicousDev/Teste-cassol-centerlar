package br.cassol.centerlar.repositories;

import br.cassol.centerlar.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
