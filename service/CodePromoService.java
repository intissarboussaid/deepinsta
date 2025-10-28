package com.deepinsta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.CodePromo;
import com.deepinsta.modal.Commande;
import com.deepinsta.modal.Discount;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.AdminRepository;
import com.deepinsta.repository.Code_PromoRepository;
import com.deepinsta.repository.CommandeRepository;
import com.deepinsta.repository.UsersRepository;

@Service
public class CodePromoService {

	
	@Autowired
	Code_PromoRepository codepromoRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	AdminService adminService;
	@Autowired
	UsersService userService;
	@Autowired
	ProductService productService;
	@Autowired
	DiscountService discountService;
	@Autowired
	CommandeRepository commandeRepository;


    CodePromoService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

	
	
	/*public CodePromo  AddCodePromo(long idAdmin,long idUser, CodePromo codePromo ) {
		if(codepromoRepository.findByAdmin(adminService.findAdminById(idAdmin))==null) {  			
			codePromo.setAdmin(adminService.findAdminById(idAdmin));
			List<Users> users = new	ArrayList<>();
			users.add(userService.FindUserByID(idUser));
			System.out.println("user name :"+userService.FindUserByID(idUser).getNom());
			codePromo.setUser(users);
			String generatedCode = generateCode(userService.FindUserByID(idUser).getNom(), codePromo.getPercent());
			codePromo.setCode(generatedCode);
			codePromo.setName(generatedCode);
			codepromoRepository.save(codePromo);
			return codePromo;			
		}
		else{
			CodePromo codePromo2=codepromoRepository.findByAdmin(adminService.findAdminById(idAdmin));
			List<Users> users =codePromo2.getUser();
			for(Users user :users) {
				if(user.getId_user()==idUser) {
					codePromo2.setPercent(codePromo.getPercent());
					codePromo2.setExpiry_date(codePromo.getExpiry_date());
					codePromo2.setStart_date(codePromo.getStart_date());
					return codepromoRepository.save(codePromo2);
					
				}else {
					users.add(userService.FindUserByID(idUser));
					codePromo2.setUser(users);
					String generatedCode = generateCode(userService.FindUserByID(idUser).getNom(), codePromo.getPercent());
					codePromo2.setCode(generatedCode);
					codePromo2.setName(generatedCode);
					codepromoRepository.save(codePromo2);
					return codePromo2;
				}
			}
			
		}
	
	}*/
	public CodePromo addCodePromo(long idAdmin, long idUser, CodePromo codePromo) {
	    Admin admin = adminService.findAdminById(idAdmin);
	    Users user = userService.FindUserByID(idUser);
	    CodePromo existingPromo = codepromoRepository.findByAdmin(admin);

	    if (existingPromo == null) {
	        codePromo.setAdmin(admin);
	        
	        List<Users> users = new ArrayList<>();
	        users.add(user);
	        codePromo.setUser(users);

	        String generatedCode = generateCode(user.getNom(), codePromo.getPercent());
	        codePromo.setCode(generatedCode);
	        codePromo.setName(generatedCode);

	        return codepromoRepository.save(codePromo);
	    } else {
	        List<Users> users = existingPromo.getUser();
	        // Check if user already exists
	        boolean userExists = users.stream()
	                                  .anyMatch(u -> u.getId_user() == idUser);
	        System.out.println("name : "+userExists);

	        if (!userExists) {
	            users.add(user);
	            existingPromo.setUser(users);

	            String generatedCode = generateCode(user.getNom(), codePromo.getPercent());
	            existingPromo.setCode(generatedCode);
	            existingPromo.setName(generatedCode);
	        }else {
	        	for(Users use : users) {
	        		if(use.getId_user()==idUser) {
	        			String generatedCode = generateCode(use.getNom(), codePromo.getPercent());
	    	            existingPromo.setCode(generatedCode);
	    	            existingPromo.setName(generatedCode);
	        			
	        		}
	        		
	        	}
	        }

	        // Update promo details regardless
	        existingPromo.setPercent(codePromo.getPercent());
	        existingPromo.setExpiry_date(codePromo.getExpiry_date());
	        existingPromo.setStart_date(codePromo.getStart_date());

	        return codepromoRepository.save(existingPromo);
	    }
	}

	
	  private String generateCode(String name, Double percent) {
		  Random random= new Random();
	        String baseName = name.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
	        baseName = baseName.length() >= 3 ? baseName.substring(0, 3) : String.format("%-3s", baseName).replace(' ', 'X');
	        int percentInt = (int) Math.round(percent);
	        String percentPart = String.format("%02d", percentInt % 100); // last 2 digits of percent

	        String base = baseName + percentPart;
	        base = base.length() > 6 ? base.substring(0, 6) : base;

	        String candidate = base;
	        int attempts = 0;

	        while (codepromoRepository.existsByCode(candidate)) {
	            // Append a random letter or digit to ensure uniqueness
	            char randomChar = (char) ('A' + random.nextInt(26));
	            candidate = (base + randomChar).substring(0, 6);
	            attempts++;
	            if (attempts > 10) {
	                throw new RuntimeException("Failed to generate unique code after 10 attempts");
	            }
	        }

	        return candidate;
	    }
	  
	  public CodePromo getByAdminAndUser(long id_admin,long id_user) {		
		  CodePromo codePromo = codepromoRepository.findByAdmin(adminService.findAdminById(id_admin));
		  for(Users user : codePromo.getUser()) {
			  if(user.getId_user()==id_user) {
				  return codePromo;
			  }
		  }
		  return null;
	  }

	  
	  public Commande SendPromoCode(long id_cmd,String name) {		
		  CodePromo codePromo = codepromoRepository.findByName(name);
		  
			  Commande cmd=commandeRepository.getById(id_cmd);
			  cmd.setTotal(cmd.getTotal()*(1-(codePromo.getPercent()/100)));
			  cmd.setCodePromo(true);
			  commandeRepository.save(cmd);
			  return cmd;
		 
		  
	  }

   

}
