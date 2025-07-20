package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;


import com.deepinsta.modal.Account;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Photo;
import com.deepinsta.repository.AccountRepository;
import com.deepinsta.repository.AdminRepository;

@Service
public class AdminService {
	
	public final AdminRepository adminRepository;
	public final AccountRepository accountRepository;
	public PhotoService photoService;
	 
	
	public AdminService (AdminRepository adminRepository,PhotoService photoService,AccountRepository accountRepository) {
		this.adminRepository=adminRepository;
		this.photoService=photoService;
		this.accountRepository=accountRepository;
	}
	
	
	//add part
	public Admin CreateAdmin(Admin adminRequest){
		return adminRepository.save(adminRequest);
	}
	// get part
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	
	public Admin findAdminById(long id_admin){
		return adminRepository.findById(id_admin);
	}
	public List<Admin> GetAllAdmin() {
		return adminRepository.findAll();
	}
	
	public ResponseEntity<byte[]> getPhoto(long id) throws IOException {
		Admin admin =findAdminById(id);
		long id_photo =admin.getPhoto().getId_photo();
	    Photo photo = photoService.getPhotoById(id_photo);
	    Path path = Paths.get(photo.getFilePath());
	    System.out.println("path photo : "+path);
	    byte[] fileBytes = Files.readAllBytes(path);
	    System.out.println("file byte photo : "+fileBytes);
	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(photo.getContentType()))
	            .body(fileBytes);
	}
	// update part
	public Admin updateAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		if(adminRequest.getAdresse()!=null) {
			admin.setAdresse(adminRequest.getAdresse());
		}else {
			admin.setAdresse(admin.getAdresse());
		}
if(adminRequest.getDate_naissance()!=null) {
	admin.setDate_naissance(adminRequest.getDate_naissance());
}else {
	admin.setAdresse(admin.getDate_naissance());
}
if(adminRequest.getPhone()=="") {

	admin.setAdresse(admin.getPhone());
}else {
	admin.setPhone(adminRequest.getPhone());
}
if(adminRequest.getDescription()=="") {
	admin.setDescription(admin.getDescription());
}else {

	admin.setDescription(adminRequest.getDescription());
}
if(adminRequest.getLocal()=="") {
	admin.setAdresse(admin.getLocal());
}else {

	admin.setLocal(adminRequest.getLocal());
}
if(adminRequest.getNationnalité()=="") {
	admin.setAdresse(admin.getNationnalité());
}else {

	admin.setNationnalité(adminRequest.getNationnalité());
}
if(adminRequest.getNom()=="") {
	admin.setAdresse(admin.getNom());
}else {
	
	admin.setNom(adminRequest.getNom());
}
if(adminRequest.getPrenom()=="") {
	admin.setAdresse(admin.getPrenom());	
}else {

	admin.setPrenom(adminRequest.getPrenom());	
}
if(adminRequest.getSexe()=="") {

	admin.setAdresse(admin.getSexe());
}else {
	admin.setSexe(adminRequest.getSexe());
}
if(adminRequest.getSite()=="") {
	admin.setAdresse(admin.getSite());
}else {
	
	admin.setSite(adminRequest.getSite());
}
if(adminRequest.getInstagramme()=="") {
	admin.setAdresse(admin.getInstagramme());
}else {
	
	admin.setInstagramme(adminRequest.getInstagramme());
}
if(adminRequest.getFacebook()=="") {
	admin.setAdresse(admin.getFacebook());
}else {

	admin.setFacebook(adminRequest.getFacebook());
}
if(adminRequest.getTiktok()=="") {
	admin.setTiktok(admin.getTiktok());
}else {

	admin.setTiktok(adminRequest.getTiktok());
}
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateAdresseAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setAdresse(adminRequest.getAdresse());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateDate_naissanceAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setDate_naissance(adminRequest.getDate_naissance());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateLocalAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setLocal(adminRequest.getLocal());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateNationnalitéAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setNationnalité(adminRequest.getNationnalité());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateNomAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setNom(adminRequest.getNom());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updatePrenomAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setPrenom(adminRequest.getPrenom());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateSexeAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setSexe(adminRequest.getSexe());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateSiteAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setSite(adminRequest.getSite());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateInstagrameAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setInstagramme(adminRequest.getInstagramme());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updatefacebookAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setFacebook(adminRequest.getFacebook());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updateTikTokAdmin(long id_admin, Admin adminRequest) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setTiktok(adminRequest.getTiktok());
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin updatePhoto(long id_admin, MultipartFile file) throws IOException {
		Admin admin=findAdminById(id_admin);
		System.out.println("file"+file.getName());
		admin.setPhoto(photoService.savePhoto(file, id_admin));
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	
	
	//delete part
	public String DeleteAdmin(long id_admin)  {
		
		Admin admin=findAdminById(id_admin);
		System.out.println("admin : "+ admin);
		Account account =accountRepository.findByAdmin(admin);
		System.out.println("account : "+ account);
		accountRepository.delete(account);
		adminRepository.delete(admin);
		return "deleted with succefully";
	}
	/*public String DeletephotoAdmin(long id_admin)  {
		Admin admin=findAdminById(id_admin);
		admin.setPhoto(null);
		Admin ad =adminRepository.save(admin);
		return "user deleted";
	}*/
	public Admin deleteAdresseAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
        admin.setAdresse(null);
        Admin ad =adminRepository.save(admin);
		return admin;
	}
	public Admin deleteDate_naissanceAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setDate_naissance(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteLocalAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setLocal(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteNationnalitéAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setNationnalité(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteNomAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setNom(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deletePrenomAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setPrenom(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteSexeAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setSexe(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteSiteAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setSite(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteInstagrameAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setInstagramme(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deletefacebookAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setFacebook(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deleteTikTokAdmin(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		admin.setTiktok(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	public Admin deletePhoto(long id_admin) throws IOException {
		Admin admin=findAdminById(id_admin);
		System.out.println("file");
		admin.setPhoto(null);
		Admin ad =adminRepository.save(admin);
		return ad;
	}
	
	

}
