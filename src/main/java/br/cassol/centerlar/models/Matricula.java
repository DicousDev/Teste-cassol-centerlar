package br.cassol.centerlar.models;

import br.cassol.centerlar.exceptions.EntidadeInvalidaException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(cascade = {CascadeType.REFRESH})
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;
  @OneToOne(cascade = {CascadeType.REFRESH})
  @JoinColumn(name = "curso_id")
  private Curso curso;
  private Double nota;

  public Matricula atualizar(Double nota) {

    if(Objects.nonNull(this.nota) && Objects.isNull(nota)) {
      throw new EntidadeInvalidaException("A nota não pode ser nula após um valor atribuido.");
    }

    if(Objects.nonNull(nota) && (nota < 0 || nota > 10)) {
      throw new EntidadeInvalidaException("A nota não pode ser menor que zero ou maior que dez.");
    }

    this.nota = nota;
    return this;
  }

}
