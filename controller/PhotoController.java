package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Photo;
import com.deepinsta.service.PhotoService;

@RestController
@RequestMapping("api/deepinsta/photo")
public class PhotoController {
	private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Photo> uploadPhoto(
        @RequestParam("file") MultipartFile file,
        @RequestParam Long userId
    ) {
        try {
            Photo savedPhoto = photoService.savePhoto(file, userId);
            return ResponseEntity.ok(savedPhoto);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    
    
	@GetMapping("find/all/photo")
	public List<Photo> AllPhoto(){
		return photoService.GetAllPhoto();	}
}
