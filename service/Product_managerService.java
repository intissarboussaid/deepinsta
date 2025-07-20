package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.repository.AdminRepository;
import com.deepinsta.repository.Product_managerRepository;

@Service
public class Product_managerService {
	
	private Product_managerRepository  product_managerRepository;
	public PhotoService photoService;
	private AdminRepository adminRepository;
	
	  public Product_managerService(Product_managerRepository  product_managerRepository, PhotoService photoService,AdminRepository adminRepository) {
	  this.product_managerRepository=product_managerRepository; 
	  this.photoService=photoService;
	  this.adminRepository = adminRepository;
}

	  
	  public Product_manager AddProduct_manager(Product_manager product_manager) {
		  return product_managerRepository.save(product_manager);
	  }
	  
	 
		//add part
		public Product_manager CreateProduct_manager(Product_manager pmRequest){
			return product_managerRepository.save(pmRequest);
		}
		// get part
		public List<Product_manager> getAllProduct_manager(){
			return product_managerRepository.findAll();
		}
		
		public Product_manager findP_M_ById(long id_pm){
			return product_managerRepository.findById(id_pm);
		}
		public List<Product_manager> GetAllProduct_manager() {
			return product_managerRepository.findAll();
		}
		//get photo
		public ResponseEntity<byte[]> getPhoto(long id) throws IOException {
			Product_manager pm =findP_M_ById(id);
			long id_photo =pm.getPhoto().getId_photo();
		    Photo photo = photoService.getPhotoById(id_photo);
		    Path path = Paths.get(photo.getFilePath());
		    byte[] fileBytes = Files.readAllBytes(path);

		    return ResponseEntity.ok()
		            .contentType(MediaType.parseMediaType(photo.getContentType()))
		            .body(fileBytes);
		}
		
		// update part
		public Product_manager updateProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager pm=findP_M_ById(id_pm);
			if(pmRequest.getAdresse()!=null) {
				pm.setAdresse(pmRequest.getAdresse());
			}
	if(pmRequest.getDate_naissance()!=null) {
		pm.setDate_naissance(pmRequest.getDate_naissance());
	}
	if(pmRequest.getPhone()!=null) {
		pm.setPhone(pmRequest.getPhone());
	}
	if(pmRequest.getDescription()!=null) {
		pm.setDescription(pmRequest.getDescription());
	}
	if(pmRequest.getLocal()!=null) {
		pm.setLocal(pmRequest.getLocal());
	}
	if(pmRequest.getNationnalité()!=null) {
		pm.setNationnalité(pmRequest.getNationnalité());
	}
	if(pmRequest.getNom()!=null) {
		pm.setNom(pmRequest.getNom());
	}
	if(pmRequest.getPrenom()!=null) {
		pm.setPrenom(pmRequest.getPrenom());	
	}
	if(pmRequest.getSexe()!=null) {
		pm.setSexe(pmRequest.getSexe());
	}
	if(pmRequest.getSite()!=null) {
		pm.setSite(pmRequest.getSite());
	}
	if(pmRequest.getInstagramme()!=null) {
		pm.setInstagramme(pmRequest.getInstagramme());
	}
	if(pmRequest.getFacebook()!=null) {
		pm.setFacebook(pmRequest.getFacebook());
	}
	if(pmRequest.getTiktok()!=null) {
		pm.setTiktok(pmRequest.getTiktok());
	}

			Product_manager ad =product_managerRepository.save(pm);
			return ad;
		}
		public Product_manager updateAdresseProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setAdresse(pmRequest.getAdresse());
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager updateDate_naissanceProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setDate_naissance(pmRequest.getDate_naissance());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updateLocalProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setLocal(pmRequest.getLocal());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updateNationnalitéProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setNationnalité(pmRequest.getNationnalité());
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager updateNomProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setNom(pmRequest.getNom());
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager updatePrenomProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setPrenom(pmRequest.getPrenom());
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager updateSexeProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setSexe(pmRequest.getSexe());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updateSiteProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setSite(pmRequest.getSite());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updateInstagrameProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setInstagramme(pmRequest.getInstagramme());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updatefacebookProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setFacebook(pmRequest.getFacebook());
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager updateTikTokProduct_manager(long id_pm, Product_manager pmRequest) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setTiktok(pmRequest.getTiktok());
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager updatePhoto(long id_pm, MultipartFile file) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			System.out.println("file"+file.getName());
			product_manager.setPhoto(photoService.savePhoto(file, id_pm));
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		
		
		//delete part
		public String DeleteProduct_manager(long id_pm)  {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_managerRepository.delete(product_manager);
			return "deleted with succefully";
		}
		public Product_manager DeletephotoProduct_manager(long id_pm)  {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setPhoto(null);
			Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager deleteAdresseproduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setAdresse(null);
	        Product_manager pm =product_managerRepository.save(product_manager);
			return pm;
		}
		public Product_manager deleteDate_naissanceProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setDate_naissance(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteLocalProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setLocal(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteNationnalitéProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setNationnalité(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteNomProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setNom(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deletePrenomProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setPrenom(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteSexeProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setSexe(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteSiteProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setSite(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteInstagrameProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setInstagramme(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deletefacebookProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setFacebook(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deleteTikTokProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			product_manager.setTiktok(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		public Product_manager deletePhotoProduct_manager(long id_pm) throws IOException {
			Product_manager product_manager=findP_M_ById(id_pm);
			System.out.println("file");
			product_manager.setPhoto(null);
			Product_manager ad =product_managerRepository.save(product_manager);
			return ad;
		}
		
}
