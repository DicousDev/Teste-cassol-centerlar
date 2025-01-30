package br.cassol.centerlar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarMatriculaDTO {

  private Long idAluno;
  private Long idCurso;
  private Double nota;
}
