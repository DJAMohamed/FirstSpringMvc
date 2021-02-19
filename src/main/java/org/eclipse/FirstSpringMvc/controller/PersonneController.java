package org.eclipse.FirstSpringMvc.controller;

import java.util.ArrayList;

import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping(value = "/addPerson")
	public String addPerson() {
		return "jsp/addPerson";
	}

	@PostMapping(value = "/addPerson")
	public ModelAndView addPerson(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		Personne p1 = new Personne(nom, prenom);
		personneRepository.save(p1);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/confirm");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		return mv;
	}

	@RequestMapping(value = "/showAll")
	public ModelAndView showAll() {
		ArrayList<Personne> al = (ArrayList<Personne>) personneRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", al);
		return mv;
	}

	@RequestMapping(value = "/showSome")
	public ModelAndView showSome(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		ArrayList<Personne> al = (ArrayList<Personne>) personneRepository.findByNomAndPrenom(nom, prenom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", al);
		return mv;
	}
}