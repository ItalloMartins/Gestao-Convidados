package com.algaworks.festa.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
public class ConvidadosController {

	@Autowired
	private Convidados convidadosRepo;
	
	@RequestMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidadosRepo.findAll());
		return modelAndView;
	}
	
	 @RequestMapping(value="/convidados", method=RequestMethod.POST)
	    public String Post(@Valid Convidado convidados){  
	        convidadosRepo.save(convidados);
	        return "redirect:/convidados";
	        }
	 
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			convidadosRepo.deleteById(id);
			return "redirect:/convidados";
		}
		
		
	 
	 
}
