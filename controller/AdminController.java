package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.service.AdminService;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/admin/")
@RequiredArgsConstructor
public class AdminController {
	
	private  AdminService adminService;
	
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
     } 
    //put part
    @PutMapping("update/Informations/{id_admin}")
    public Admin AddInformations(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	 System.out.println("test")  ;
    	Admin ad = adminService.updateAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/adresse/{id_admin}")
    public Admin UpdateAdresseAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateAdresseAdmin(id_admin, admin);
    	return ad;
    }

    @PutMapping("update/birth/date/{id_admin}")
    public Admin UpdateDate_naissanceAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateDate_naissanceAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/facebook/{id_admin}")
    public Admin UpdateFacebookAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updatefacebookAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/instagrame/{id_admin}")
    public Admin UpdateInstagrameAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateInstagrameAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/tiktok/{id_admin}")
    public Admin UpdateTikTokAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateTikTokAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/local/{id_admin}")
    public Admin UpdateLocalAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateLocalAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/nationnalite/{id_admin}")
    public Admin UpdateNationaliteAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateNationnalitéAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/nom/{id_admin}")
    public Admin UpdateNomAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateNomAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/prenom/{id_admin}")
    public Admin UpdatePrenomAdmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updatePrenomAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/photo/{id_admin}")
    public Admin UpdatePhotoAdmin(@PathVariable("id_admin") long id_admin, @RequestParam(name = "file") MultipartFile file) throws IOException {
    	System.out.println("test");
    	Admin ad = adminService.updatePhoto(id_admin, file);
    	return ad;
    }
    @PutMapping("update/sexe/{id_admin}")
    public Admin UpdateSexedmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateSexeAdmin(id_admin, admin);
    	return ad;
    }
    @PutMapping("update/site/{id_admin}")
    public Admin UpdateSitedmin(@PathVariable("id_admin") long id_admin,@RequestBody Admin admin) throws IOException {
    	Admin ad = adminService.updateSiteAdmin(id_admin, admin);
    	return ad;
    }
    
    
    //get part
    @GetMapping("all")
    public List<Admin> FindAllAdmin(){
    	return adminService.getAllAdmin();
    }
    @GetMapping("{id_admin}")
    public Admin FindAdmin(@PathVariable("id_admin")long id_admin){
    	return adminService.findAdminById(id_admin);
    }
	  /*get photo*/
	  @GetMapping("photo/{id_admin}")
		public ResponseEntity<?> getPhoto(@PathVariable("id_admin") long id_admin) throws IOException {
		  return adminService.getPhoto(id_admin);
		}
    //delete part
    
    @PutMapping("delete/adresse/{id_admin}")
    public Admin DeleteAdresseAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteAdresseAdmin(id_admin);
    	return ad;
    }

    @PutMapping("delete/birth/date/{id_admin}")
    public Admin DeleteDate_naissanceAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteDate_naissanceAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/facebook/{id_admin}")
    public Admin DeleteFacebookAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deletefacebookAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/instagrame/{id_admin}")
    public Admin DeleteInstagrameAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteInstagrameAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/tiktok/{id_admin}")
    public Admin DeleteTikTokAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteTikTokAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/local/{id_admin}")
    public Admin DeleteLocalAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteLocalAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/nationnalite/{id_admin}")
    public Admin DeleteNationaliteAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteNationnalitéAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/nom/{id_admin}")
    public Admin DeleteNomAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteNomAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/prenom/{id_admin}")
    public Admin DeletePrenomAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deletePrenomAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/photo/{id_admin}")
    public Admin DeletePhotoAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	System.out.println("test");
    	Admin ad = adminService.deletePhoto(id_admin);
    	return ad;
    }
    @PutMapping("delete/sexe/{id_admin}")
    public Admin DeleteSexedmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteSexeAdmin(id_admin);
    	return ad;
    }
    @PutMapping("delete/site/{id_admin}")
    public Admin DeleteSitedmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	Admin ad = adminService.deleteSiteAdmin(id_admin);
    	return ad;
    }
    @DeleteMapping("delete/admin/{id_admin}")
    public String DeleteAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
    	String ad = adminService.DeleteAdmin(id_admin);
    	return ad;
    }
    
}
