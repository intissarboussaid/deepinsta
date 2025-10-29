package com.deepinsta.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Color_qte;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.repository.AdminRepository;
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
	    private  Colors_qte_sizeService colors_qte_sizeService ;
	
	public ProductService(ProductRepository productRepository,PhotoRepository photoRepository,Product_managerRepository product_managerRepository, AdminRepository adminRepository,PhotoService photoService) {
		this.productRepository=productRepository;
		this.photoRepository=photoRepository;
		this.product_managerRepository =product_managerRepository;
		this.photoService = photoService;
		this.adminRepository=adminRepository;
	}
	//add new product By PM
	public Product CreateNewProductByPM(long id,Product product) throws IOException {
		Product_manager product_manger= product_managerRepository.findById(id);
		product.setPm(product_manger);
		product.setRating(0);
		product.setDate(LocalDateTime.now());
		return productRepository.save(product);
	}
	//add new product By Admin
	public Product CreateNewProductByAdmin(long id,Product product ) throws IOException {
		Admin admin= adminRepository.findById(id);
		product.setAdmin(admin);
		product.setRating(0);
		product.setDate(LocalDateTime.now());
		product.setDiscount_price(0.0);		
		return productRepository.save(product);
	}
	//add photo by id photo:	
	public Product AddPhotoProduct(long id,List<MultipartFile> files) throws IOException {
		Product product= productRepository.GetProductById(id);
		List<Photo> newPhotos = photoService.savePhotoProduct(files, id);
		if(product.getPhotos()!=null) {
			 List<Photo> allPhotos = new ArrayList<>(product.getPhotos());
		        allPhotos.addAll(newPhotos);
		        product.setPhotos(allPhotos);
		}
		else {
			product.setPhotos(newPhotos);	
		}
		System.out.println("photos product "+product.getPhotos());
		return productRepository.save(product);
	}
		
	public Double GetPercente(long id_product)throws IOException {
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
    //Find products by Admin
	public List<Product> GetProductsByAdmin(long id) {
	Admin admin =adminRepository.findById(id);
	List<Product> products=productRepository.GetProductByAdmin(admin);
		return products;
	}
	
	//edit product
	
	public Product EditProduct(long id, Product responseProduct)  {
		 Product product = GetProductById(id);
			 if(responseProduct.getCost_price()!=0) {
				 product.setCost_price(responseProduct.getCost_price());
			 }
			 if(responseProduct.getSale_price()!=0) {
				 product.setSale_price(responseProduct.getSale_price());
			 }
			 if(responseProduct.getName()!=null) {
				 product.setName(responseProduct.getName());
			 }
			 if(responseProduct.getDescription()!=null) {
				 product.setDescription(responseProduct.getDescription());
			 }
			 if(responseProduct.getDate()!=null) {
				 product.setDate(responseProduct.getDate());
			 }
			 if(responseProduct.getNbre_cmd()!=0) {
				 product.setNbre_cmd(responseProduct.getNbre_cmd());
			 }
			 if(responseProduct.getView()!=0) {
				 product.setView(responseProduct.getView());
			 }
			 if(responseProduct.getQte()!=0) {
				 product.setQte(responseProduct.getQte());
			 }
			 if(responseProduct.getType()!=null) {
				 product.setType(responseProduct.getType());
			 }
			 if(responseProduct.getProduct()!=null) {
				 product.setProduct(product.getProduct());
			 }
			 if(responseProduct.getCurrency()!=null) {
				 product.setCurrency(product.getCurrency());
			 }
			 if(responseProduct.getQuality()!=null) {
				 product.setQuality(responseProduct.getQuality());
			 }
			 if(responseProduct.getBrand()!=null) {
				 product.setBrand(responseProduct.getBrand());
			 }
			 if(responseProduct.getPercent()!=0) {
				 product.setPercent(responseProduct.getPercent());
			 }
			 if(responseProduct.getStatus()!=null) {
				 product.setStatus(responseProduct.getStatus());
			 }
			 if(responseProduct.getColor()!=null) {
				 product.setColor(responseProduct.getColor());
			 }
			 if(responseProduct.getSize()!=null) {
				 product.setSize(product.getSize());
			 }
			 if(responseProduct.getWeight()!=0) {
				 product.setWeight(responseProduct.getWeight());
			 }
			 if(responseProduct.getDimensions()!=null) {
				 product.setDimensions(product.getDimensions());
			 }
			 if(responseProduct.getMaterial()!=null) {
				 product.setMaterial(product.getMaterial());
			 }
			 if(responseProduct.getAuthor()!=null) {
				 product.setAuthor(product.getAuthor());
			 }
			 if(responseProduct.getFlavor()!=null) {
				 product.setFlavor(product.getFlavor());
			 }
			 if(responseProduct.getGender()!=null) {
				 product.setGender(product.getGender());
			 }		
			 if(responseProduct.getLevel()!=null) {
				 product.setLevel(product.getLevel());
			 }		
			 if(responseProduct.getStock()!=null) {
				 product.setStock(product.getStock());
			 }
		 productRepository.save(product);
		 return product;
		
	}
	
	public Product deleteProduct(long id) {
		Product product=GetProductById(id);
		product.setIs_delete(true);
		productRepository.save(product);
		return product ;
	}
	public Product RemoveDiscount(long id_product) {
		Product product=GetProductById(id_product) ;
		product.setDiscount_percent(0.0);
		product.setDiscount_price(0.0);
		return productRepository.save(product);
	}
    //Find products by Admin
    public Product saveProduct(Product product) {
    	return productRepository.save(product);
    }
		
}
