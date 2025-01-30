package br.cassol.centerlar.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaView {

  private Long id;
  private AlunoView aluno;
  private CursoView curso;
  private Double nota;
}
