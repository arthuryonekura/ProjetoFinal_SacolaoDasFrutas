package com.projetoFinal.sacolaoDasFrutas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoFinal.sacolaoDasFrutas.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Categoria findByNome(String nome);
}