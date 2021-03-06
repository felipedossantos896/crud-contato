package br.com.fellps.contato.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fellps.contato.model.Contato;
import br.com.fellps.contato.model.Status;
import br.com.fellps.contato.service.ContatoService;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroContato");
		mv.addObject(new Contato());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Contato contato, Errors errors, RedirectAttributes redirectAttributes) {
		if(errors.hasErrors()) {
			System.out.println("Tem erro!");
			return "CadastroContato";
		}
		
		System.out.println("Salvando");
		contatoService.salvar(contato);
		redirectAttributes.addFlashAttribute("mensagem", "Contato salvo com sucesso!");
		return "redirect:/contatos/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("PesquisaContato");
		mv.addObject("contatos", contatoService.listar());
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public String excluir(@PathVariable Long codigo) {
		contatoService.remover(codigo);
		return "redirect:/contatos";
	}
	
	
	@ModelAttribute("todosStatus")
	public List<Status> todosStatus() {
		return Arrays.asList(Status.values());
	}
	
}
