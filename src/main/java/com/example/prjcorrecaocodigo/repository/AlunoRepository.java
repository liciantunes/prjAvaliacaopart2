package com.example.prjcorrecaocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prjcorrecaocodigo.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//Query Methods
	List<Aluno> findByCidade(String cidade);
	Aluno findByRa(String ra);
	List<Aluno> buscarAlunoPorNomeERenda(String nome, Double renda);
	List<Aluno> findByAlunoPorNome(String nome);
	List<Aluno> findCidadeERenda(String cidade, Double renda);
	List<Aluno> findByNomeCompletoLike(String nomeCompleto);
	List<Aluno> findByTurmaId(Long turmaId);
	Aluno salvarAluno(Aluno aluno);

}
