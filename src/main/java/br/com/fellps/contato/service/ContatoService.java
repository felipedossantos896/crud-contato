package br.com.fellps.contato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fellps.contato.model.Contato;
import br.com.fellps.contato.repository.Contatos;

@Service
public class ContatoService {

	@Autowired
	private Contatos contatos;
	
	public void salvar(Contato contato) {
		contatos.save(contato);
	}
	
	public List<Contato> listar() {
		return contatos.findAll();
	}
	
	public void remover(Long codigo) {
		Contato contato = contatos.findOne(codigo);
		contatos.delete(contato);
	}
	
}
