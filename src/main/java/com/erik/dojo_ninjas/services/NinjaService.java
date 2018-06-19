package com.erik.dojo_ninjas.services;


import org.springframework.stereotype.Service;

import com.erik.dojo_ninjas.models.Dojo;
import com.erik.dojo_ninjas.models.Ninja;
import com.erik.dojo_ninjas.repo.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo nRepo;
	public NinjaService(NinjaRepo nrepo) {
		this.nRepo = nrepo;
	}
	public Ninja createNinja(Ninja n) {
		return nRepo.save(n);
	}
}
