package br.com.camc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.camc.cursomc.domain.Categoria;
import br.com.camc.cursomc.repositories.CategoriaRepository;
import br.com.camc.cursomc.services.exceptions.DataIntegrityException;
import br.com.camc.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Long id){
		Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado Id: " + id
					+ ", Tipo " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setid(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getid());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}

	}
}
