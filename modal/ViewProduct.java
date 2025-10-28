package com.deepinsta.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="views")
public class ViewProduct {
	@Id
	@Column(name = "id_view")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_view;
	
	  @ManyToOne
	    private Users user;

	    @ManyToOne
	    private Product product;
	    
	    private LocalDateTime  viewedAt;

		public long getId_view() {
			return id_view;
		}

		public void setId_view(long id_view) {
			this.id_view = id_view;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public LocalDateTime getViewedAt() {
			return viewedAt;
		}

		public void setViewedAt(LocalDateTime viewedAt) {
			this.viewedAt = viewedAt;
		}

		public ViewProduct(long id_view, Users user, Product product, LocalDateTime viewedAt) {
			super();
			this.id_view = id_view;
			this.user = user;
			this.product = product;
			this.viewedAt = viewedAt;
		}

		public ViewProduct() {
			super();
		}
	    
	    

}
