package com.erik.dojo_ninjas.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erik.dojo_ninjas.models.Dojo;
import com.erik.dojo_ninjas.models.Ninja;
import com.erik.dojo_ninjas.services.DojoService;
import com.erik.dojo_ninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	@GetMapping("/ninjas/new")
	public String renderNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> dojos = dojoService.allDojos();
//		List<String> dojo_names = new ArrayList<String>();
//		Map<Dojo,String> dojosMap = new HashMap<Dojo,String>();
//		for(int i = 0; i < dojos.size(); i++) {
//			dojosMap.put(dojos.get(i),dojos.get(i).getName());
//		}
//		System.out.println(dojo_names);
		model.addAttribute("allDojos", dojos);
		return "ninjas.jsp";
	}
	@PostMapping("/ninjas/new")
	public String postNinja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		List<Dojo> dojos = dojoService.allDojos();
//		List<String> dojo_names = new ArrayList<String>();
//		Map<Dojo,String> dojosMap = new HashMap<Dojo,String>();
//		for(int i = 0; i < dojos.size(); i++) {
//			dojosMap.put(dojos.get(i), dojos.get(i).getName());
//		}
//		System.out.println(dojo_names);
		model.addAttribute("allDojos", dojos);
		if(result.hasErrors()) {
			System.out.println("invalid ninja");
		}
		else {
			//create
			ninjaService.createNinja(ninja);
		}
		return"ninjas.jsp";
	}
	@GetMapping("/dojos/new")
	public String renderDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String postDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("invalid dojo");
		}
		else {
			//create
			System.out.println("---CREATE DOJO----");
			System.out.println(dojo.getName());
			dojoService.createDojo(dojo);
		}
		return "dojo.jsp";
	}
	@RequestMapping("/dojos/{dojo_id}")
	public String location(@PathVariable("dojo_id") Long id, Model model) {
		Dojo this_dojo = dojoService.findDojo(id);
		if(this_dojo == null) {
			return "redirect:/dojos/new";
		}
		List<Ninja> ninjas = this_dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo",id);
		model.addAttribute("dojo_name", this_dojo.getName());
		return "location.jsp";
	}
}