package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Product;
import com.deepinsta.modal.RegisterRequest;
import com.deepinsta.modal.ViewProduct;
import com.deepinsta.service.ViewProductService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/view/product/")
@RequiredArgsConstructor
public class ViewProductController {
	
	@Autowired
	ViewProductService viewService;
	
	@PostMapping("add/{id_product}/{id_user}")
	 public ViewProduct AddViewByProductAndUser(@PathVariable("id_product") long id_product, @PathVariable("id_user")  long id_user ) throws IOException {
		ViewProduct view = viewService.addView(id_product, id_user);
	    return view;
	    }

}
