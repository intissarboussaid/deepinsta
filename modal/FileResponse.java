package com.deepinsta.modal;

import java.util.List;

import org.springframework.http.ResponseEntity;

public class FileResponse {
	    private  List<byte[]> image;

		public List<byte[]> getImage() {
			return image;
		}
		public void setImage(List<byte[]> image) {
			this.image = image;
		}
		public FileResponse() {
			super();
		}
		public FileResponse( List<byte[]> images) {
			super();
			this.image = images;
		}
	    

}
