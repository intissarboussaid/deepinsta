package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.FileResponse;
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
    //save photos by id_roduct
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
	public ResponseEntity<byte[]> getPhoto(long id) throws IOException {
	    Photo photo = getPhotoById(id);
	    Path path = Paths.get(photo.getFilePath());
	    System.out.println("path photo : "+path);
	    byte[] fileBytes = Files.readAllBytes(path);
	    System.out.println("file byte photo : "+fileBytes);
	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(photo.getContentType()))
	            .body(fileBytes);
	}
	
	public byte[] findPhoto(long id) throws IOException {
	    Photo photo = getPhotoById(id);
	    Path path = Paths.get(photo.getFilePath());
	    System.out.println("path photo : "+path);
	    byte[] fileBytes = Files.readAllBytes(path);
	    System.out.println("file byte photo : "+fileBytes);
	    return fileBytes;
	}
	
	
	public List<ResponseEntity<byte[]>> getPhotos(List<Photo> photos) throws IOException {
	List<ResponseEntity<byte[]>> images = new ArrayList<>();
		   for (Photo photo : photos) {		   
			   ResponseEntity<byte[]> image=getPhoto(photo.getId_photo());
			   images.add(image);
		   }
		   images.addAll(images);
	    

	    return images;
	          
	}
    
    public List<Photo> GetAllPhoto(){
    	return photoRepository.findAll();
    }
    public Photo getPhotoById(long id) {
    	return photoRepository.findById(id);
    }
    public void deletePhoto(long id) {
    	Photo photo = getPhotoById(id);
    	photoRepository.delete(photo);
    }
    
    
    
    
}
