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

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Avis;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.repository.AdminRepository;
import com.deepinsta.repository.AvisRepository;
import com.deepinsta.repository.PhotoRepository;
import com.deepinsta.repository.ProductRepository;
import com.deepinsta.repository.Product_managerRepository;

@Service
public class ProductService {

    private final PhotoService photoService;
	
	    private ProductRepository productRepository;
	    private Product_managerRepository product_managerRepository;
	    private final Path path = Paths.get("uploads");
	    private  PhotoRepository photoRepository ;
	    private  AdminRepository adminRepository ;
	    private AvisService avisService;
	
	public ProductService(ProductRepository productRepository,PhotoRepository photoRepository,Product_managerRepository product_managerRepository, AdminRepository adminRepository,PhotoService photoService, AvisService avisService) {
		this.productRepository=productRepository;
		this.photoRepository=photoRepository;
		this.product_managerRepository =product_managerRepository;
		this.photoService = photoService;
		this.adminRepository=adminRepository;
		this.avisService=avisService;
	}
	//add new product
	public Product CreateNewProduct(long id,Product product) throws IOException {
		Product_manager product_manger= product_managerRepository.findById(id);
		product.setPm(product_manger);
		return productRepository.save(product);
	}
	//add photo:
	
	public Product AddPhotoProduct(long id,List<MultipartFile> files) throws IOException {
		Product product= productRepository.GetProductById(id);
		product.setPhotos(photoService.savePhotoProduct(files, id));
		System.out.println("photos product "+product.getPhotos());
		return productRepository.save(product);
	}
	
	public float GetPercente(long id_product)throws IOException {
		Product product = productRepository.GetProductById(id_product);
		return  product.getPercent();
	}
	// Get Product by name
	public List<Product> GetProductByName(String name) {
		return productRepository.GetProductByName(name);
	}
	// Get Product by type
		public List<Product> GetProductByType(String type) {
			return productRepository.GetProductByType(type);
		}
		
	// Get Product by id
		public Product GetProductById(long id) {
			return productRepository.GetProductById(id);
				}
	// Get Product by price
		public List<Product> GetProductByPrice(float price) {
			return productRepository.GetProductByPrice(price);
				}
	// Get Product by Less Price
		public List<Product> GetProductByLessPrice(float price) {
			return productRepository. GetProductByLessPrice(price);
						}
	//Find all products
	public List<Product> GetProducts() {
	return productRepository.findAll();
						}
    //Find products by type
	public List<Product> GetProductsByType(String type) {
	return productRepository. GetProductByType(type);
						}
	
		
}
