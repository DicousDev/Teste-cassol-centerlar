package br.cassol.centerlar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatricularAlunoDTO {

  private Long cursoId;
  private Long alunoId;
}
