package com.eclettica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eclettica.model.Utente;
import com.eclettica.service.UtenteService;

@Controller
@RequestMapping(value="/utente")
public class UtenteController {
	
	@Autowired
	 UtenteService utenteService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("utente_list");
	  List<Utente> utenteList = utenteService.getAllUtenti();
	  model.addObject("utenteList", utenteList);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/addUtente/", method=RequestMethod.GET)
	 public ModelAndView addutente() {
	  ModelAndView model = new ModelAndView();
	  
	  Utente utente = new Utente();
	  model.addObject("utenteForm", utente);
	  model.setViewName("utente_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/updateUtente/{id}", method=RequestMethod.GET)
	 public ModelAndView editUtente(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  
	  Utente utente = utenteService.getUtenteById(id);
	  model.addObject("utenteForm", utente);
	  model.setViewName("utente_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/saveUtente", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("utenteForm") Utente utente) {
	  utenteService.saveOrUpdate(utente);
	  
	  return new ModelAndView("redirect:/utente/list");
	 }
	 
	 @RequestMapping(value="/deleteUtente/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") long id) {
	  utenteService.deleteUtente(id);
	  
	  return new ModelAndView("redirect:/utente/list");
	 }

}
