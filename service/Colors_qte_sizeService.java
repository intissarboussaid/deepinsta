package com.deepinsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Color_qte;
import com.deepinsta.repository.ColorSizeQteRepository;

@Service
public class Colors_qte_sizeService {
	@Autowired
	private ColorSizeQteRepository color_size_qte;
	
	public List<Color_qte> Add(List<Color_qte> details ){		
		color_size_qte.saveAll(details);		
		return details;
		
	}

	public Color_qte AddDetail(Color_qte details) {
		System.out.println("class detail: "+details);
		return color_size_qte.save(details);
	}
	public List<Color_qte> findByColor(String color) {
		return color_size_qte.findByColor(color);
	}
	public List<Color_qte> findBySize(String size) {
		return color_size_qte.findBysize(size);
	}
	public Color_qte save(Color_qte body) {
		return color_size_qte.save(body);
	}

}
