package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product;
import com.deepinsta.service.ProductService;

@RestController
@RequestMapping("api/deepinsta/product")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	
	@PostMapping("/add/{id_pm}")
	 public Product AddProduct(@PathVariable("id_pm") long id_pm,@RequestBody Product product) throws IOException {
	    	System.out.println("test");
	    	Product products = productService.CreateNewProduct(id_pm, product);
	    	return products;
	    }
	
	
	//add photo product 
	@PutMapping("add/photo/{id_product}")
	public Product AddPhotosProduct(@PathVariable("id_product") long id_product,@RequestParam(name = "file")List< MultipartFile> file) throws IOException {
		return productService.AddPhotoProduct(id_product, file);
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
	//get all products
	@GetMapping("find/all")
	public List<Product> FindProducts() throws IOException {
		return productService.GetProducts();
	}

	//get all products by type
		@GetMapping("find/by/type/{type}")
		public List<Product> FindProductsByType(@PathVariable("type") String type) throws IOException {
			return productService.GetProductByType(type);
		}
		//get percent
		@GetMapping("get/percent")
		public float AddPercentProduct(@PathVariable("id_product") long id_product) throws IOException {
			return productService.GetPercente(id_product);
		}
	
}
