package br.com.camc.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{
	private static final long serialVersionUID = 8613544916583665486L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCidade;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="idEstado")
	private Estado estado;
	
	public Cidade() {
	}

	public Cidade(Long idCidade, String nome, Estado estado) {
		super();
		this.idCidade = idCidade;
		this.nome = nome;
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCidade == null) ? 0 : idCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (idCidade == null) {
			if (other.idCidade != null)
				return false;
		} else if (!idCidade.equals(other.idCidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [idCidade=" + idCidade + ", nome=" + nome + "]";
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}	

}
