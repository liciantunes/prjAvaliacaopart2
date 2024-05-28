package com.example.prjcorrecaocodigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prjcorrecaocodigo.entities.Aluno;
import com.example.prjcorrecaocodigo.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private final AlunoRepository alunoRepository;
    
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAluno() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method 
    public List<Aluno> buscarAlunoPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }
    //Query Method 
    public List<Aluno> buscarAlunoPorNomeERenda(String nome, Double renda) {
        return alunoRepository.buscarAlunoPorNomeERenda(nome,renda); 
      }
    //Query Method 
    public List<Aluno> buscarAlunoPorNome(String nome) {
        return alunoRepository.findByAlunoPorNome(nome); 
      }
  //Query Method 
    public List<Aluno> buscarCidadeERenda(String cidade, Double renda) {
        return alunoRepository.findCidadeERenda(cidade,renda); 
      }
  //@query
    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByAlunoPorNome(nome);
    }
  //@query
    public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
        return alunoRepository.findByNomeCompletoLike(nomeCompleto);
    }
   //@query
    public List<Aluno> findByTurmaId(Long turmaId) {
        return alunoRepository.findByTurmaId(turmaId);
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.salvarAluno(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
