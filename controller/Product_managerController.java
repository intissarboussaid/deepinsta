package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.modal.Users;
import com.deepinsta.service.Product_managerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/product_manager/")
@RequiredArgsConstructor
public class Product_managerController {
	
	private Product_managerService product_managerService;
	
	public Product_managerController(Product_managerService product_managerService) {
		this.product_managerService=product_managerService;
	}
	
	 @PutMapping("All/Informations/{id_pm}")
	    public Product_manager AddInformations(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	 System.out.println("test")  ;
	    	 Product_manager pm = product_managerService.updateProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/pmresse/{id_pm}")
	    public Product_manager UpdateAdresseProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateAdresseProduct_manager(id_pm, product_manager);
	    	return pm;
	    }

	    @PutMapping("update/birth/date/{id_pm}")
	    public Product_manager UpdateDate_naissanceProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateDate_naissanceProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/facebook/{id_pm}")
	    public Product_manager UpdateFacebookProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updatefacebookProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/instagrame/{id_pm}")
	    public Product_manager UpdateInstagrameProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateInstagrameProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/tiktok/{id_pm}")
	    public Product_manager UpdateTikTokProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateTikTokProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/local/{id_pm}")
	    public Product_manager UpdateLocalProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateLocalProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/nationnalite/{id_pm}")
	    public Product_manager UpdateNationaliteAProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateNationnalitéProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/nom/{id_pm}")
	    public Product_manager UpdateNomProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateNomProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/prenom/{id_pm}")
	    public Product_manager UpdatePrenomProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updatePrenomProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/photo/{id_pm}")
	    public Product_manager UpdatePhotoProduct_manager(@PathVariable("id_pm") long id_pm, @RequestParam(name = "file") MultipartFile file) throws IOException {
	    	System.out.println("test");
	    	Product_manager pm = product_managerService.updatePhoto(id_pm, file);
	    	return pm;
	    }
	    @PutMapping("update/sexe/{id_pm}")
	    public Product_manager UpdateSexeProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateSexeProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    @PutMapping("update/site/{id_pm}")
	    public Product_manager UpdateSiteProduct_manager(@PathVariable("id_pm") long id_pm,@RequestBody Product_manager product_manager) throws IOException {
	    	Product_manager pm = product_managerService.updateSiteProduct_manager(id_pm, product_manager);
	    	return pm;
	    }
	    
	    
	    //get part
	    @GetMapping("all")
	    public List<Product_manager> FindAllProduct_manager(){
	    	return product_managerService.getAllProduct_manager();
	    }
	    @GetMapping("{id_pm}")
	    public Product_manager FindProduct_manager(@PathVariable("id_pm") long id_pm){
	    	return product_managerService.findP_M_ById(id_pm);
	    }
		  @GetMapping("photo/{id_admin}")
			public ResponseEntity<?> getPhoto(@PathVariable("id_admin") long id_admin) throws IOException {
			  return product_managerService.getPhoto(id_admin);
			}
	    
	    //delete part
	    
	    @PutMapping("delete/pmresse/{id_pm}")
	    public Product_manager DeleteAdresseProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteAdresseproduct_manager(id_pm);
	    	return pm;
	    }

	    @PutMapping("delete/birth/date/{id_pm}")
	    public Product_manager DeleteDate_naissanceProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteDate_naissanceProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/facebook/{id_pm}")
	    public Product_manager DeleteFacebookProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deletefacebookProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/instagrame/{id_pm}")
	    public Product_manager DeleteInstagrameProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteInstagrameProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/tiktok/{id_pm}")
	    public Product_manager DeleteTikTokProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteTikTokProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/local/{id_pm}")
	    public Product_manager DeleteLocalProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteLocalProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/nationnalite/{id_pm}")
	    public Product_manager DeleteNationaliteProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteNationnalitéProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/nom/{id_pm}")
	    public Product_manager DeleteNomProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteNomProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/prenom/{id_pm}")
	    public Product_manager DeletePrenomAProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deletePrenomProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/photo/{id_pm}")
	    public Product_manager DeletePhotoAProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	System.out.println("test");
	    	Product_manager pm = product_managerService.DeletephotoProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/sexe/{id_pm}")
	    public Product_manager DeleteSexeProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteSexeProduct_manager(id_pm);
	    	return pm;
	    }
	    @PutMapping("delete/site/{id_pm}")
	    public Product_manager DeleteSiteProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	Product_manager pm = product_managerService.deleteSiteProduct_manager(id_pm);
	    	return pm;
	    }
	    @DeleteMapping("delete/site/{id_pm}")
	    public String DeleteProduct_manager(@PathVariable("id_pm") long id_pm) throws IOException {
	    	String pm = product_managerService.DeleteProduct_manager(id_pm);
	    	return pm;
	    }

	    

}
