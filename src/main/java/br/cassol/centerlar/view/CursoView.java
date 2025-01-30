package br.cassol.centerlar.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CursoView {

  private Long id;
  private String nome;
  private String descricao;
}
