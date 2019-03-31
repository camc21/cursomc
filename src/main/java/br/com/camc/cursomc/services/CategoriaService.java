package br.com.camc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camc.cursomc.domain.Categoria;
import br.com.camc.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Long id){
		Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new br.com.camc.cursomc.services.exceptions.ObjectNotFoundException(
					"Objeto não encontrado Id: " + id
					+ ", Tipo " + Categoria.class.getName()));
	}
}
