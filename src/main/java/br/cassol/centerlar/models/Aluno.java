package br.cassol.centerlar.models;

import br.cassol.centerlar.dto.AtualizarAlunoDTO;
import br.cassol.centerlar.exceptions.EntidadeInvalidaException;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  public Aluno atualizar(AtualizarAlunoDTO aluno) {

    if(Objects.isNull(aluno)) {
      throw new EntidadeInvalidaException("Não foi possível atualizar dados do aluno");
    }

    if(StringUtils.isBlank(aluno.getNome())) {
      throw new EntidadeInvalidaException("Não é possível excluir nome do aluno");
    }

    this.nome = aluno.getNome();
    return this;
  }
}
