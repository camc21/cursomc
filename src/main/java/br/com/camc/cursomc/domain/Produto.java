package br.com.camc.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = -4557820361807907804L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	private String nome;
	private Double preco;
	
	@ManyToMany(mappedBy="categorias")
	@JoinTable(name="PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "idProduto"),
		inverseJoinColumns = @JoinColumn(name="idCategoria"))
	
	public List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
		
	}
	
	public Produto(Long idProduto, String nome, Double preco) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return idProduto;
	}
	public void setId(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
	
}