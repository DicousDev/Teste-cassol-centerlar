package br.cassol.centerlar.api;

import br.cassol.centerlar.dto.AtualizarAlunoDTO;
import br.cassol.centerlar.dto.CadastrarAlunoDTO;
import br.cassol.centerlar.services.AlunoService;
import br.cassol.centerlar.view.AlunoView;
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
@RequestMapping("/alunos")
public class AlunoApi {

  private final AlunoService service;

  @GetMapping
  public Collection<AlunoView> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public AlunoView pesquisar(@PathVariable("id") Long idAluno) {
    return service.pesquisarToView(idAluno);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AlunoView cadastrar(@RequestBody CadastrarAlunoDTO aluno) {
    return service.cadastrar(aluno);
  }

  @PutMapping("/{id}")
  public AlunoView atualizar(@PathVariable("id") Long idAluno, @RequestBody AtualizarAlunoDTO aluno) {
    return service.atualizar(idAluno, aluno);
  }

  @DeleteMapping("/{id}")
  public void remover(@PathVariable("id") Long idAluno) {
    service.remover(idAluno);
  }
}
