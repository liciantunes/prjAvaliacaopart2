package com.example.prjcorrecaocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.prjcorrecaocodigo.entities.Turma;
import com.example.prjcorrecaocodigo.service.TurmaService;

@RestController
@RequestMapping

public class TurmaController {
    
    private final TurmaService turmaService;
    
    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getProductById(@PathVariable Long id) {
        Turma turma = turmaService.getTurmaById(id);
        if (turma != null) {
            return ResponseEntity.ok(turma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Turma>> getAllTurmas() {
        List<Turma> turma = turmaService.getAllTurma();
        return ResponseEntity.ok(turma);
    }

    @PostMapping("/")
    public ResponseEntity<Turma> criarTurma(@RequestBody @Validated Turma turma) {
        Turma criarTurma = turmaService.salvarTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarTurma);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Long id, @RequestBody @Validated Turma turma) {
        Turma updatedTurma = turmaService.updateTurma(id, turma);
        if (updatedTurma != null) {
            return ResponseEntity.ok(updatedTurma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turma> deleteTurma(@PathVariable Long id) {
        boolean deleted = turmaService.deleteTurma(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       
 }
