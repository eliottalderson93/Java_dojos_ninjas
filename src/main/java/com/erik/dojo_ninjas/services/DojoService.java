package com.erik.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.dojo_ninjas.models.Dojo;
import com.erik.dojo_ninjas.repo.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dRepo;
	public DojoService(DojoRepo drepo) {
		this.dRepo = drepo;
	}
	public Dojo createDojo(Dojo d) {
		return dRepo.save(d);
	}
	public List<Dojo> allDojos(){
		return (List<Dojo>) dRepo.findAll();
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dRepo.findById(id);
		if (optDojo.isPresent()) {
			return optDojo.get();
		}
		else {
			return null;
		}
	}
}
