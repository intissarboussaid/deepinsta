package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="photo")
public class Photo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_photo")
	private long id_photo;
    @Column(name="name")
    private String name;  
    @Column(name="filename")
    private String filename;  
    @Column(name="file_path")
    private String filePath; 
    @Column(name="content_type")
    private String contentType; 
    @Column(name="size")
    private Long size;
	public long getId_photo() {
		return id_photo;
	}
	public void setId_photo(long id_photo) {
		this.id_photo = id_photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Photo() {
		super();
	}
    
	
	
}
