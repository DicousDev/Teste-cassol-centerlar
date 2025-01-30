package br.cassol.centerlar.api;

import br.cassol.centerlar.dto.AtualizarMatriculaDTO;
import br.cassol.centerlar.dto.MatricularAlunoDTO;
import br.cassol.centerlar.services.MatriculaService;
import br.cassol.centerlar.view.MatriculaView;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matriculas")
public class MatriculaApi {

  private final MatriculaService service;

  @GetMapping
  public Collection<MatriculaView> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public MatriculaView pesquisar(@PathVariable("id") Long idMatricula) {
    return service.pesquisarToView(idMatricula);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MatriculaView matricularAluno(@RequestBody MatricularAlunoDTO matricula) {
    return service.matricularAluno(matricula.getAlunoId(), matricula.getCursoId());
  }

  @PutMapping("/{id}")
  public MatriculaView atualizarNota(@PathVariable("id") Long idMatricula, @RequestBody AtualizarMatriculaDTO matricula) {
    return service.atualizar(idMatricula, matricula);
  }

  @DeleteMapping("/{id}")
  public void remover(@PathVariable("id") Long idMatricula) {
    service.remover(idMatricula);
  }
}
