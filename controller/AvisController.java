package com.deepinsta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Avis;
import com.deepinsta.service.AvisService;


@RestController
@RequestMapping("api/deepinsta/avis")
public class AvisController {
	
	//@Autowired
	private AvisService avisService;
	
	
	public AvisController(AvisService avisService) {
		this.avisService=avisService;
	}
	
	@PostMapping("add/new/{id_user}/{id_product}")
	public Avis CreateAvis(@PathVariable(name="id_user")long id_user,@PathVariable(name="id_product")long id_product, @RequestBody Avis avis) {
		return avisService.createAvis(id_user,id_product, avis);
	}
	
	@PutMapping("update/{id_avis}")
	public Avis UpdateAvis(@PathVariable(name="id_avis")long id_avis, @RequestBody Avis avis) {
		return avisService.UpdateAvis(id_avis,avis);
	}
	
	
	@GetMapping("find/all")
	public List<Avis> GetAllAviss() {
		return avisService.GetAllAvis();
	}
	
	@GetMapping("find/id/{id_avis}")
	public Avis GetById(@PathVariable(name="id_avis")long id_avis) {
		return avisService.GetByID(id_avis);
	}
	
	@GetMapping("find/by/product/{id_product}")
	public List<Avis> GetByProduct(@PathVariable(name="id_product")long id_product) {
		return avisService.GetFromProduct(id_product);
	}

}
