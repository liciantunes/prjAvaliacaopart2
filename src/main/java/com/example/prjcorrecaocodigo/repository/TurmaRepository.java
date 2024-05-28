package com.example.prjcorrecaocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prjcorrecaocodigo.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	Turma salvarTurma(Turma turma);
}
