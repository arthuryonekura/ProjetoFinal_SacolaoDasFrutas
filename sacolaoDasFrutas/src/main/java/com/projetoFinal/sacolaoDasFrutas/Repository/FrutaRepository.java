package com.projetoFinal.sacolaoDasFrutas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoFinal.sacolaoDasFrutas.Entity.Fruta;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta, Long> {
	Fruta findByNome(String nome);
}