package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.UsersRepository;

@Service
public class UsersService {
	
	
	private UsersRepository usersRepository;
	public PhotoService photoService;
	
	public UsersService(UsersRepository usersRepository,PhotoService photoService) {
		this.usersRepository=usersRepository;
		this.photoService=photoService;
	}
	
	
	public Users AddUser(Users user) {
		return usersRepository.save(user);
		
	}
	public Users FindUserByID(long id) {
		return usersRepository.GetById(id);
	}
	
	public Users updatePhoto(long id_user, MultipartFile file) throws IOException {
		Users user=FindUserByID(id_user);
		System.out.println("file"+file.getName());
		user.setPhoto(photoService.savePhoto(file, id_user));
		usersRepository.save(user);
		return user;
	}
	
	
	//get part
	//get photo
	
	public ResponseEntity<byte[]> getPhoto(long id) throws IOException {
		Users user =FindUserByID(id);
		long id_photo =user.getPhoto().getId_photo();
	    Photo photo = photoService.getPhotoById(id_photo);
	    Path path = Paths.get(photo.getFilePath());
	    byte[] fileBytes = Files.readAllBytes(path);

	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(photo.getContentType()))
	            .body(fileBytes);
	}
	
	
	
	public Users updateUser(long id_user, Users userRequest) throws IOException {
		Users user=FindUserByID(id_user);
		if(userRequest.getAdresse()!=null) {
			user.setAdresse(userRequest.getAdresse());
		}
if(userRequest.getDate_naissance()!=null) {
	user.setDate_naissance(userRequest.getDate_naissance());
}
if(userRequest.getPhone()!=null) {
	user.setPhone(userRequest.getPhone());
}
if(userRequest.getDescription()!=null) {
	user.setDescription(userRequest.getDescription());
}
if(userRequest.getLocal()!=null) {
	user.setLocal(userRequest.getLocal());
}
if(userRequest.getNationnalité()!=null) {
	user.setNationnalité(userRequest.getNationnalité());
}
if(userRequest.getNom()!=null) {
	user.setNom(userRequest.getNom());
}
if(userRequest.getPrenom()!=null) {
	user.setPrenom(userRequest.getPrenom());	
}
if(userRequest.getSexe()!=null) {
	user.setSexe(userRequest.getSexe());
}
if(userRequest.getSite()!=null) {
	user.setSite(userRequest.getSite());
}
if(userRequest.getInstagramme()!=null) {
	user.setInstagramme(userRequest.getInstagramme());
}
if(userRequest.getFacebook()!=null) {
	user.setFacebook(userRequest.getFacebook());
}
if(userRequest.getTiktok()!=null) {
	user.setTiktok(userRequest.getTiktok());
}

		//admin.setPhoto(photoService.savePhoto(file, id_admin));
		Users use =usersRepository.save(user);
		return use;
	}

}
