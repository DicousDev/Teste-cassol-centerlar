package br.cassol.centerlar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarCursoDTO {

  private String nome;
  private String descricao;
}
