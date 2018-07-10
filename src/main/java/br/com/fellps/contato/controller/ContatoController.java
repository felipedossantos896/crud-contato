package br.com.fellps.contato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fellps.contato.model.Contato;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroContato");
		mv.addObject(new Contato());
		return mv;
	}
	
}
