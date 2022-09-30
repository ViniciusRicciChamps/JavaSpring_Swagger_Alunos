package com.alunos.apiRest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.apiRest.models.Alunos;
import com.alunos.apiRest.repository.AlunosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Alunos")
@CrossOrigin(origins = "*")
public class AlunoResource {

	@Autowired
	AlunosRepository alunosRepository;
	
	@GetMapping("/alunos")
	@ApiOperation(value = "retorna uma lista de alunos")
	public List<Alunos> listaAlunos(){
		return alunosRepository.findAll();
	}
	
	@GetMapping("/alunos/{id}")
	@ApiOperation(value = "retorna um aluno especifico de acordo com o ID")
	public Alunos listaAlunoID(@PathVariable(value = "id") long id){
		return alunosRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	@ApiOperation(value = "seta um aluno na tabela do banco")
	public Alunos salvarAluno(@RequestBody Alunos alunos) {
		return alunosRepository.save(alunos);
	}
	
	@DeleteMapping("/deletar/{id}")
	@ApiOperation(value = "apaga um aluno especifico de acordo com o ID")
	public Alunos deletarAluno(@PathVariable(value= "id") long id) {
		return alunosRepository.deleteById(id);
	}
	
	@PutMapping("/alterar")
	@ApiOperation(value = "altera um determinado aluno passando o ID pelo corpo da requisição")
	public Alunos alterarAluno(@RequestBody Alunos alunos) {
		
		return alunosRepository.save(alunos);
	}
	
}
