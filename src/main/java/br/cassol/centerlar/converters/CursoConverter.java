package br.cassol.centerlar.converters;

import br.cassol.centerlar.dto.CadastrarCursoDTO;
import br.cassol.centerlar.view.CursoView;
import br.cassol.centerlar.models.Curso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class CursoConverter {

  public Curso toModel(CadastrarCursoDTO curso) {
    return Curso.builder()
        .nome(curso.getNome())
        .descricao(curso.getDescricao())
        .build();
  }

  public Collection<CursoView> toView(Collection<Curso> cursos) {

    if(Objects.isNull(cursos)) {
      return new ArrayList<>();
    }

    return cursos.stream()
        .map(this::toView)
        .toList();
  }

  public CursoView toView(Curso curso) {
    return CursoView.builder()
        .id(curso.getId())
        .nome(curso.getNome())
        .descricao(curso.getDescricao())
        .build();
  }

}
