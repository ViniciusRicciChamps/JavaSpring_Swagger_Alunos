package com.alunos.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.apiRest.models.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {

	Alunos findById(long id);
	Alunos deleteById(long id);
	
}
