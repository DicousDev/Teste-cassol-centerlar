package br.cassol.centerlar.converters;

import br.cassol.centerlar.dto.CadastrarAlunoDTO;
import br.cassol.centerlar.models.Aluno;
import br.cassol.centerlar.view.AlunoView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class AlunoConverter {


  public Aluno toModel(CadastrarAlunoDTO aluno) {
    return Aluno.builder().nome(aluno.getNome()).build();
  }

  public Collection<AlunoView> toView(Collection<Aluno> alunos) {

    if(Objects.isNull(alunos)) {
      return new ArrayList<>();
    }

    return alunos.stream().map(this::toView).toList();
  }

  public AlunoView toView(Aluno aluno) {
    return AlunoView.builder()
        .id(aluno.getId())
        .nome(aluno.getNome())
        .build();
  }
}
