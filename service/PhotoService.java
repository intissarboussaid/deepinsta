package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product;
import com.deepinsta.repository.PhotoRepository;
import com.deepinsta.repository.ProductRepository;

@Service
public class PhotoService {
	
	private final Path path = Paths.get("uploads");
    private  PhotoRepository photoRepository ;
    private ProductRepository productRepository;
    
    
    //inject dependency repository in this service to make it work when we run project to use it!
    public PhotoService(PhotoRepository photoRepository,ProductRepository productRepository) {
        this.photoRepository = photoRepository;
        this.productRepository=productRepository;
    }
    
    public Photo savePhoto(MultipartFile file, long id) throws IOException {
        // 1. Generate a unique filename
        String filename = id + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        
        // 2. Save file to disk
        Files.createDirectories(path);
        Path destination = path.resolve(filename);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        // 3. Save metadata to DB
        Photo photo = new Photo();
        photo.setFilename(filename);
        photo.setName(file.getOriginalFilename());
        photo.setFilePath(destination.toString());
        photo.setContentType(file.getContentType());
        photo.setSize(file.getSize());
        
        return photoRepository.save(photo);
    }
    public List<Photo> savePhotoProduct(List<MultipartFile> files, long id_product) throws IOException {
        // 1. Generate a unique filename
    	  
    	 List<Photo> photos = new ArrayList<>();
    	  for (MultipartFile file : files) {
        String filename = id_product + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
     
        // 2. Save file to disk
        Files.createDirectories(path);
        Path destination = path.resolve(filename);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        // 3. Save metadata to DB
        Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setFilePath(destination.toString());
        photo.setContentType(file.getContentType());
        photo.setSize(file.getSize());
        photos.add(photo);

    	  }  
    	  
          return   photoRepository.saveAll(photos);    
    }

    
    public List<Photo> GetAllPhoto(){
    	return photoRepository.findAll();
    }
    public Photo getPhotoById(long id) {
    	return photoRepository.findById(id);
    }
    
    
    
    
}
