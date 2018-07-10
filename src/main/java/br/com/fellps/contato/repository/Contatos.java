package br.com.fellps.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fellps.contato.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
