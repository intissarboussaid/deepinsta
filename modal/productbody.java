package com.deepinsta.modal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class productbody {
	

	double cost_price;
	double sale_price;
	Double discount_price;
	Double discount_percent;
	String name;
	String description;
	LocalDateTime date;
	int nbre_cmd;
	int view;
	int qte;
	String type;
	String product;
	String currency;
	String quality;
	String brand;
	double percent;
	private Admin admin;
	String status; 
	List<String> color;
	 List<String> size; 
	 double Weight ;
	 String dimensions;
	 String material ;
	 String author ;
	 String flavor;
	 String gender;
	 String level;
	 String stock;

	private List<Photo> photos = new ArrayList<>();	

	private List<Color_qte> color_size_qte = new ArrayList<>();	

	private List<Discount> discount;
		

}
