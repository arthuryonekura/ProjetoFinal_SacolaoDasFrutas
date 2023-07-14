package com.projetoFinal.sacolaoDasFrutas.Entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class Fruta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = true, length = 250)
	private String descricao;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;
	@Column(nullable = false, length = 100)
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Frutas [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", categoria=" + categoria + "]";
	}

}
