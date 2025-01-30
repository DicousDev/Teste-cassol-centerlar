package br.cassol.centerlar.services;

import br.cassol.centerlar.converters.CursoConverter;
import br.cassol.centerlar.dto.AtualizarCursoDTO;
import br.cassol.centerlar.dto.CadastrarCursoDTO;
import br.cassol.centerlar.view.CursoView;
import br.cassol.centerlar.exceptions.NaoEncontradoException;
import br.cassol.centerlar.models.Curso;
import br.cassol.centerlar.repositories.CursoRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CursoService {

  private final CursoRepository repository;
  private final CursoConverter converter;

  public Collection<CursoView> getAll() {
    List<Curso> cursos = repository.findAll();
    return converter.toView(cursos);
  }

  public Optional<Curso> pesquisar(Long idCurso) {
    return repository.findById(idCurso);
  }

  public CursoView pesquisarToView(Long idCurso) {
    Curso curso = pesquisar(idCurso).orElseThrow(() -> new NaoEncontradoException(String.format("Curso [%s] não encontrado", idCurso)));
    return converter.toView(curso);
  }

  public CursoView cadastrar(CadastrarCursoDTO curso) {
    Curso save = converter.toModel(curso);
    save = repository.saveAndFlush(save);
    return converter.toView(save);
  }


  @Transactional
  public CursoView atualizar(Long idCurso, AtualizarCursoDTO curso) {
    Curso cursoPesquisado = pesquisar(idCurso).orElseThrow(() -> new NaoEncontradoException(String.format("Curso [%s] não encontrado", idCurso)));
    cursoPesquisado = cursoPesquisado.atualizar(curso);
    return converter.toView(cursoPesquisado);
  }

  @Transactional
  public Boolean remover(Long idCurso) {
    pesquisar(idCurso).orElseThrow(() -> new NaoEncontradoException(String.format("Curso [%s] não encontrado", idCurso)));
    repository.deleteById(idCurso);
    return true;
  }
}
