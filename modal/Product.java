package com.deepinsta.modal;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_product;
	@Column(name="cost_price")
	double cost_price;
	@Column(name="sale_price")
	double sale_price;
	@Column(name="discount_price")
	Double discount_price;
	@Column(name="discount_percent")
	Double discount_percent;
	@Column(name="name")
	String name;
	@Column(columnDefinition = "TEXT") 
	String description;
	@Column(name="date")
	LocalDateTime date;
	@Column(name="nbre_cmd")
	int nbre_cmd;
	@Column(name="view")
	int view;
	@Column(name="qte")
	int qte;
	@Column(name="rest_qte")
	int rest_qte;
	@Column(name="is_delete")
	boolean is_delete;
	public int getRest_qte() {
		return rest_qte;
	}




	public void setRest_qte(int rest_qte) {
		this.rest_qte = rest_qte;
	}


	@Column(name="type")
	String type;
	@Column(name="product")
	String product;
	@Column(name="currency")
	String currency;
	@Column(name="quality")
	String quality;
	@Column(name="brand")
	String brand;
	@Column(name="percent")
	double percent;
	@ManyToOne
	@JoinColumn(name="id_pm")
	private Product_manager pm;
	@ManyToOne
	@JoinColumn(name="id_admin")
	private Admin admin;
	 @Column(name="status") 
	String status;
	 @Column(name="color") 
	List<String> color;
	 @Column(name="size") 
	 List<String> size;
	 @Column(name="weight") 
	 double Weight ;
	 @Column(name="dimensions")
	 String dimensions;
	 @Column(name="material")
	 String material ;
	 @Column(name="author")
	 String author ;
	 @Column(name="flavor")
	 String flavor;
	 @Column(name="gender")
	 String gender;
	 @Column(name="level")
	 String level;
	 @Column(name="stock")
	 String stock;
	 
	 @Column(name="color_cmd")
	 String color_cmd;
	 @Column(name="size_cmd")
	 String size_cmd;
	@OneToMany
	@JoinColumn(name = "photo")
	private List<Photo> photos = new ArrayList<>();	
	
	@OneToMany
	@JoinColumn(name = "color_size_qte")
	private List<Color_qte> color_size_qte = new ArrayList<>();	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<Discount> discount;
	 @Column(name="rating") 
	 Double rating; 
		
	
	
	public long getId_product() {
		return id_product;
	}




	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	



	public List<Color_qte> getColor_size_qte() {
		return color_size_qte;
	}




	public boolean isIs_delete() {
		return is_delete;
	}




	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}




	public void setColor_size_qte(List<Color_qte> color_size_qte) {
		this.color_size_qte = color_size_qte;
	}




	public Double getDiscount_percent() {
		return discount_percent;
	}




	public void setDiscount_percent(Double discount_percent) {
		this.discount_percent = discount_percent;
	}




	public double getCost_price() {
		return cost_price;
	}




	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}



	public double getSale_price() {
		return sale_price;
	}




	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}




	public Double getDiscount_price() {
		return discount_price;
	}




	public void setDiscount_price(Double discount_price) {
		this.discount_price = discount_price;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}







	public LocalDateTime getDate() {
		return date;
	}




	public double getRating() {
		return rating;
	}




	public void setRating(double rating) {
		this.rating = rating;
	}




	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}




	public int getNbre_cmd() {
		return nbre_cmd;
	}




	public void setNbre_cmd(int nbre_cmd) {
		this.nbre_cmd = nbre_cmd;
	}




	public int getView() {
		return view;
	}




	public void setView(int view) {
		this.view = view;
	}




	public int getQte() {
		return qte;
	}




	public void setQte(int qte) {
		this.qte = qte;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getProduct() {
		return product;
	}




	public void setProduct(String product) {
		this.product = product;
	}




	public String getCurrency() {
		return currency;
	}




	public void setCurrency(String currency) {
		this.currency = currency;
	}




	public String getQuality() {
		return quality;
	}




	public void setQuality(String quality) {
		this.quality = quality;
	}




	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public double getPercent() {
		return percent;
	}




	public void setPercent(double percent) {
		this.percent = percent;
	}





	public Product_manager getPm() {
		return pm;
	}




	public void setPm(Product_manager pm) {
		this.pm = pm;
	}




	public Admin getAdmin() {
		return admin;
	}




	public void setAdmin(Admin admin) {
		this.admin = admin;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public List<String> getColor() {
		return color;
	}




	public void setColor(List<String> color) {
		this.color = color;
	}




	public List<String> getSize() {
		return size;
	}




	public void setSize(List<String> size) {
		this.size = size;
	}




	public double getWeight() {
		return Weight;
	}




	public void setWeight(double weight) {
		Weight = weight;
	}




	public String getDimensions() {
		return dimensions;
	}




	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}




	public String getMaterial() {
		return material;
	}




	public void setMaterial(String material) {
		this.material = material;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getFlavor() {
		return flavor;
	}




	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getLevel() {
		return level;
	}




	public void setLevel(String level) {
		this.level = level;
	}




	public List<Photo> getPhotos() {
		return photos;
	}




	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}




	public String getStock() {
		return stock;
	}




	public void setStock(String stock) {
		this.stock = stock;
	}





	public List<Discount> getDiscount() {
		return discount;
	}




	public void setDiscount(List<Discount> discount) {
		this.discount = discount;
	}






	

	public void setRating(Double rating) {
		this.rating = rating;
	}




	public String getColor_cmd() {
		return color_cmd;
	}




	public void setColor_cmd(String color_cmd) {
		this.color_cmd = color_cmd;
	}




	public String getSize_cmd() {
		return size_cmd;
	}




	public void setSize_cmd(String size_cmd) {
		this.size_cmd = size_cmd;
	}


	public Product() {
		super();
	}

	
		

	
}
