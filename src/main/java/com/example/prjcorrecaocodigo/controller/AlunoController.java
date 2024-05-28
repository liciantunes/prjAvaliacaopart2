package com.example.prjcorrecaocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prjcorrecaocodigo.entities.Aluno;
import com.example.prjcorrecaocodigo.service.AlunoService;

@RestController
@RequestMapping

public class AlunoController {
    
    private final AlunoService alunoService;
    
    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    //Query Method
    @Query
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Aluno>> findAlunoPorCidade(@PathVariable String cidade) {
      List<Aluno> alunos = alunoService.buscarAlunoPorCidade(cidade);
      return ResponseEntity.ok(alunos);
    }
    
    @Query
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunoPorNome(@PathVariable String nome) {
      List<Aluno> alunos = alunoService.buscarAlunoPorNome(nome);
      return ResponseEntity.ok(alunos);
    }
    
    @Query
    @GetMapping("/nome/{nome}")
    public List<Aluno> findByAlunoPorNome(@PathVariable String nome) {
        return alunoService.findByNome(nome);
    }
    
    @Query
    @GetMapping("/nome-completo/{nomeCompleto}")
    public List<Aluno> findByPorNomeCompletoLike(@PathVariable String nomeCompleto) {
        return alunoService.findByNomeCompletoLike(nomeCompleto);
    }
    
    @Query
    @GetMapping("/turma/{turmaId}")
    public List<Aluno> findByTurmaId(@PathVariable Long turmaId) {
        return alunoService.findByTurmaId(turmaId);
    }
      
    @Query
    @GetMapping("/nome/{nome}/renda/{renda}")
    public ResponseEntity<List<Aluno>> buscarAlunoPorNomeERenda(@PathVariable String nome,@PathVariable Double renda) {
      List<Aluno> aluno = alunoService.buscarAlunoPorNomeERenda(nome,renda);
      return ResponseEntity.ok(aluno);
    }
    
    @Query
    @GetMapping("/cidade/{cidade}/renda/{renda}")
    public ResponseEntity<List<Aluno>> buscarCidadeERenda(@PathVariable String cidade,@PathVariable Double renda) {
      List<Aluno> aluno = alunoService.buscarCidadeERenda(cidade,renda);
      return ResponseEntity.ok(aluno);
    }

    @Query
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getProductById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    public ResponseEntity<List<Aluno>> getAllAluno() {
        List<Aluno> aluno = alunoService.getAllAluno();
        return ResponseEntity.ok(aluno);
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> criarAluno(@RequestBody @Validated Aluno aluno) {
        Aluno criarAluno = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody @Validated Aluno aluno) {
        Aluno updatedAluno = alunoService.updateAluno(id, aluno);
        if (updatedAluno != null) {
            return ResponseEntity.ok(updatedAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable Long id) {
        boolean deleted = alunoService.deleteAluno(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       
 }
