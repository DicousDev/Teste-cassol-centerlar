package br.cassol.centerlar.api;

import br.cassol.centerlar.dto.AtualizarCursoDTO;
import br.cassol.centerlar.dto.CadastrarCursoDTO;
import br.cassol.centerlar.services.CursoService;
import br.cassol.centerlar.view.CursoView;
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
@RequestMapping("/cursos")
public class CursoApi {

  private final CursoService service;

  @GetMapping
  public Collection<CursoView> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public CursoView pesquisar(@PathVariable("id") Long idCurso) {
    return service.pesquisarToView(idCurso);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CursoView cadastrar(@RequestBody CadastrarCursoDTO curso) {
    return service.cadastrar(curso);
  }

  @PutMapping("/{id}")
  public CursoView atualizar(@PathVariable("id") Long idCurso, @RequestBody AtualizarCursoDTO curso) {
    return service.atualizar(idCurso, curso);
  }

  @DeleteMapping
  public void remover(@PathVariable("id") Long idCurso) {
    service.remover(idCurso);
  }
}
