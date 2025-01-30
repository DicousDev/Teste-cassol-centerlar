package br.cassol.centerlar.services;

import br.cassol.centerlar.converters.AlunoConverter;
import br.cassol.centerlar.dto.AtualizarAlunoDTO;
import br.cassol.centerlar.dto.CadastrarAlunoDTO;
import br.cassol.centerlar.exceptions.NaoEncontradoException;
import br.cassol.centerlar.models.Aluno;
import br.cassol.centerlar.repositories.AlunoRepository;
import br.cassol.centerlar.view.AlunoView;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

  private final AlunoRepository repository;
  private final AlunoConverter converter;

  public Collection<AlunoView> getAll() {
    List<Aluno> alunos = repository.findAll();
    return converter.toView(alunos);
  }

  public AlunoView cadastrar(CadastrarAlunoDTO aluno) {
    Aluno save = converter.toModel(aluno);
    save = repository.save(save);
    return converter.toView(save);
  }

  public Optional<Aluno> pesquisar(Long idAluno) {
    return repository.findById(idAluno);
  }

  public AlunoView pesquisarToView(Long idAluno) {
    Aluno aluno = pesquisar(idAluno).orElseThrow(() -> new NaoEncontradoException(String.format("Aluno [%s] não encontrado", idAluno)));
    return converter.toView(aluno);
  }

  @Transactional
  public AlunoView atualizar(Long idAluno, AtualizarAlunoDTO aluno) {
    Aluno alunoPesquisado = pesquisar(idAluno).orElseThrow(() -> new NaoEncontradoException(String.format("Aluno [%s] não encontrado", idAluno)));
    alunoPesquisado = alunoPesquisado.atualizar(aluno);
    return converter.toView(alunoPesquisado);
  }

  @Transactional
  public Boolean remover(Long idAluno) {
    pesquisar(idAluno).orElseThrow(() -> new NaoEncontradoException(String.format("Aluno [%s] não encontrado", idAluno)));
    repository.deleteById(idAluno);
    return true;
  }
}
