package br.cassol.centerlar.services;

import br.cassol.centerlar.converters.MatriculaConverter;
import br.cassol.centerlar.dto.AtualizarMatriculaDTO;
import br.cassol.centerlar.exceptions.NaoEncontradoException;
import br.cassol.centerlar.models.Aluno;
import br.cassol.centerlar.models.Curso;
import br.cassol.centerlar.models.Matricula;
import br.cassol.centerlar.repositories.MatriculaRepository;
import br.cassol.centerlar.view.MatriculaView;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MatriculaService {

  private final AlunoService alunoService;
  private final CursoService cursoService;
  private final MatriculaRepository repository;
  private final MatriculaConverter converter;


  public Collection<MatriculaView> getAll() {
    List<Matricula> matriculas = repository.findAll();
    return converter.toView(matriculas);
  }

  public Optional<Matricula> pesquisar(Long idMatricula) {
    return repository.findById(idMatricula);
  }

  public MatriculaView pesquisarToView(Long idMatricula) {
    Matricula matricula = pesquisar(idMatricula).orElseThrow(() -> new NaoEncontradoException(String.format("Matricula [%s] não encontrada", idMatricula)));
    return converter.toView(matricula);
  }

  @Transactional
  public MatriculaView matricularAluno(Long idAluno, Long idCurso) {
    Curso curso = cursoService.pesquisar(idCurso).orElseThrow(() -> new NaoEncontradoException(String.format("Curso [%s] não encontrado.", idCurso)));
    Aluno aluno = alunoService.pesquisar(idAluno).orElseThrow(() -> new NaoEncontradoException(String.format("Aluno [%s] não encontrado.", idAluno)));

    Matricula matricula = converter.toModel(curso, aluno);
    matricula = repository.save(matricula);
    return converter.toView(matricula);
  }

  @Transactional
  public MatriculaView atualizar(Long idMatricula, AtualizarMatriculaDTO matricula) {
    Matricula matriculaPesquisada = pesquisar(idMatricula).orElseThrow(() -> new NaoEncontradoException(String.format("Matricula [%s] não encontrada.", idMatricula)));

    cursoService.pesquisar(matricula.getIdCurso()).orElseThrow(() -> new NaoEncontradoException(String.format("Curso [%s] não encontrado.", matricula.getIdCurso())));
    alunoService.pesquisar(matricula.getIdAluno()).orElseThrow(() -> new NaoEncontradoException(String.format("Aluno [%s] não encontrado.", matricula.getIdAluno())));

    matriculaPesquisada = matriculaPesquisada.atualizar(matricula.getNota());
    return converter.toView(matriculaPesquisada);
  }

  @Transactional
  public Boolean remover(Long idMatricula) {
    pesquisar(idMatricula).orElseThrow(() -> new NaoEncontradoException(String.format("Matricula [%s] não encontrada.", idMatricula)));
    repository.deleteById(idMatricula);
    return true;
  }
}
