package br.cassol.centerlar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarCursoDTO {
  private String nome;
  private String descricao;
}
