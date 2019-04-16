package br.com.camc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camc.cursomc.domain.Pedido;
import br.com.camc.cursomc.repositories.PedidoRepository;
import br.com.camc.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repo;
	
	public Pedido find(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto não encontrador Id: " + id
						+ "Tipo: " + Pedido.class.getName()));
	}

}
