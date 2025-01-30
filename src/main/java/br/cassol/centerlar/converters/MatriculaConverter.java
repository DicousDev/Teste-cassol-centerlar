package br.cassol.centerlar.converters;

import br.cassol.centerlar.models.Aluno;
import br.cassol.centerlar.models.Curso;
import br.cassol.centerlar.models.Matricula;
import br.cassol.centerlar.view.AlunoView;
import br.cassol.centerlar.view.MatriculaView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatriculaConverter {

  private final AlunoConverter alunoConverter;
  private final CursoConverter cursoConverter;

  public Matricula toModel(Curso curso, Aluno aluno) {
    Matricula matricula = Matricula.builder()
        .curso(curso)
        .aluno(aluno)
        .build();

    return matricula;
  }

  public Collection<MatriculaView> toView(Collection<Matricula> matriculas) {

    if(Objects.isNull(matriculas)) {
      return new ArrayList<>();
    }

    return matriculas.stream()
        .map(this::toView)
        .toList();
  }

  public MatriculaView toView(Matricula matricula) {
    return MatriculaView.builder()
        .id(matricula.getId())
        .aluno(alunoConverter.toView(matricula.getAluno()))
        .curso(cursoConverter.toView(matricula.getCurso()))
        .nota(matricula.getNota())
        .build();
  }
}
