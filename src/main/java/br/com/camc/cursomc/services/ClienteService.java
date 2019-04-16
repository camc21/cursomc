package br.com.camc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camc.cursomc.domain.Cliente;
import br.com.camc.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Long id){
		Optional<Cliente> obj = repo.findById(id);
			return obj.orElseThrow(() -> new br.com.camc.cursomc.services.exceptions.ObjectNotFoundException(
					"Objeto não encontrado Id: " + id
					+ ", Tipo " + Cliente.class.getName()));
	}
}
