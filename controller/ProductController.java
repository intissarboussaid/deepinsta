package com.deepinsta.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.deepinsta.modal.Color_qte;
import com.deepinsta.modal.Product;
import com.deepinsta.service.Colors_qte_sizeService;
import com.deepinsta.service.PhotoService;
import com.deepinsta.service.ProductService;
import com.deepinsta.service.ViewProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/product")
public class ProductController {

	private ProductService productService;
	private PhotoService photoService;
	private ViewProductService viewProduct;
	private Colors_qte_sizeService detailsService;
	
	public ProductController(ProductService productService,PhotoService photoService,ViewProductService viewProduct,Colors_qte_sizeService detailsService) {
		this.productService=productService;
		this.photoService=photoService;
		this.viewProduct=viewProduct;
		this.detailsService=detailsService;
	}
	
	
	@PostMapping("/add/by/pm/{id_pm}")
	 public Product AddProduct(@PathVariable("id_pm") long id_pm,@RequestBody Product product) throws IOException {
	    	System.out.println("test");
	    	Product products = productService.CreateNewProductByPM(id_pm, product);
	    	return products;
	    }
	
	@PostMapping("/add/details")
	 public Color_qte  AddDetailsProduct(@RequestBody Color_qte details) throws IOException {
	    	return detailsService.AddDetail(details);
	    }
	@GetMapping("get/by/id/{id_product}")
	public Product GetProduct(@PathVariable("id_product") long id_product) {
		return productService.GetProductById(id_product);
				
	}
	
	@PostMapping("/addProduct/by/admin/{id_admin}")
	 public Product AddProductByAdmin(@PathVariable("id_admin") long id_admin,@RequestPart("product") Product product,@RequestPart(name = "files")List< MultipartFile> files) throws IOException {
		System.out.println("test");
		List<Color_qte> colors = product.getColor_size_qte();
		System.out.println(" length details "+colors.size());
		List<String>color=new ArrayList<>();
		List<String>size=new ArrayList<>();
		int qte = 0;
		for(Color_qte detail:colors) {
			System.out.println("color details"+detail.getColor());
			color.add(detail.getColor());
			size.add(detail.getSize());
			System.out.println(" id details"+detail.getId_cq());
			System.out.println(" size colors"+detail.getSize());
			System.out.println(" quantity colors"+detail.getQte());
			qte+=detail.getQte();
			detail.setRest_qte(detail.getQte());
			AddDetailsProduct	(detail);	
		}
		product.setColor(color);
		product.setQte(qte);
		product.setRest_qte(qte);
		product.setSize(size);
		Product products = productService.CreateNewProductByAdmin(id_admin, product);
		productService.AddPhotoProduct(products.getId_product(), files);
	    return products;
	    }
	
	@PostMapping("/addPhoto/by/product/{id_product}")
	 public Product AddPotoByProduct(@PathVariable("id_product") long id_product,@RequestPart(name = "files")List< MultipartFile> files) throws IOException {
		Product product=productService.AddPhotoProduct(id_product, files);
	    return product;
	    }
	
	//add photo product 
	@PutMapping("add/photo/{id_product}")
	public Product AddPhotosProduct(@PathVariable("id_product") long id_product,@RequestParam(name = "files")List< MultipartFile> files) throws IOException {
		return productService.AddPhotoProduct(id_product, files);
	}

	//Get product by name
	@GetMapping("find/name/{name}")
	public List<Product> FindProductByName(@PathVariable("name") String name) throws IOException {
		return productService.GetProductByName(name);
	}
	//Get product by price
	@GetMapping("find/price/{price_f}")
	public List<Product> FindProductPrice(@PathVariable("price_f") float price_f) throws IOException {
		return productService.GetProductByPrice(price_f);
	}
	
	//Find product by Less than price
	@GetMapping("find/less/price/{price_f}")
	public List<Product> FindProductLessThanPrice(@PathVariable("price_f") float price_f) throws IOException {
		return productService.GetProductByLessPrice(price_f);
	}
	
	//Find products by Admin
	@GetMapping("find/byAdmin/{id_admin}")
	public List<Product>  FindProductByAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
		List<Product> products =productService.GetProductsByAdmin(id_admin);
		/*for (Product product : products) {
			viewProduct.addView(product.getId_product());
		}*/
		return products;
	}
	
	//get all products
	@GetMapping("find/all")
	public List<Product> FindProducts() throws IOException {
		return productService.GetProducts();
	}
	
	@GetMapping("get/photo/product/{id_product}")
	public List<ResponseEntity<byte[]>> FindPhotosProduct(@PathVariable("id_product") long id_product) throws IOException {
		Product product=productService.GetProductById(id_product);
		
		return photoService.getPhotos(product.getPhotos());
	}

	//get all products by type
		@GetMapping("find/by/type/{type}")
		public List<Product> FindProductsByType(@PathVariable("type") String type) throws IOException {
			return productService.GetProductByType(type);
		}
		//get percent
		@GetMapping("get/percent")
		public double AddPercentProduct(@PathVariable("id_product") long id_product) throws IOException {
			return productService.GetPercente(id_product);
		}
		//edit Product
		@PutMapping("/edit/{id_product}")
		public Product EditProduct(@PathVariable("id_product") long id_product,@RequestBody Product product)  {
			return productService.EditProduct(id_product, product);
		}
		
		@DeleteMapping("/delete/{id_product}")
		public Product deleteProduct(@PathVariable("id_product") long id_product) {
			return productService.deleteProduct(id_product);
			
					
		}
		@GetMapping("remove/discount/{id_product}")
		public Product removeDiscountsProduct(@PathVariable("id_product") long id_product) throws IOException {
			return productService.RemoveDiscount(id_product);
		}
			

}
