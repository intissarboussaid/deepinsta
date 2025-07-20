package com.deepinsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Avis;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.AvisRepository;
import com.deepinsta.repository.ProductRepository;
import com.deepinsta.repository.UsersRepository;

import lombok.RequiredArgsConstructor;


@Service
public class AvisService {

	private AvisRepository avisRepository;

	private ProductRepository productRepository;

	private UsersRepository usersRepository;
	
	public AvisService(AvisRepository avisRepository,ProductRepository productRepository,UsersRepository usersRepository) {
		this.avisRepository=avisRepository;
		this.productRepository=productRepository;
		this.usersRepository=usersRepository;
	}
	
	
	
 /*   public Avis createAvis(long id_product,Avis avis) {
    	int totalAvis=1;
    	Product product=productRepository.getById(id_product);
        avis.setProduct(product);
        List<Avis> aviss = avisRepository.GetAvisByProduct(product);
        System.out.println("all avis: " +aviss);
        totalAvis = aviss.size() + 1;
        avis.setNbre_avis(totalAvis);
        long p=0;
        long t=5;
        for (Avis av : aviss) {
        	p +=av.getCount_avis();
            System.out.println("Count Nbre Avis + 1 : " +av.getNbre_avis());
            System.out.println("Count Avis p : " +p);
            float percentage=(p/(t*totalAvis))*100;
           avis.setPercentage(percentage);
           System.out.println("purcentage : " +av.getPercentage());
        }
        avisRepository.saveAll(aviss);
        return avisRepository.save(avis);
    }
*/
	  public Avis GetByID(long id) {
	    	 return avisRepository.FindById(id);
	     }

    public Avis  createAvis(long id_user,long id_product, Avis avis) {
        Product product = productRepository.GetProductById(id_product);
        avis.setProduct(product);
        Users user = usersRepository.GetById(id_user);
        avis.setUser(user);
        List<Avis> aviss = avisRepository.FindByProduct(product);
        System.out.println("All avis: " + aviss);

        int totalAvis = aviss.size() + 1;
        avis.setNbre_avis(totalAvis);

        long totalNote = 0;
        for (Avis av : aviss) {
            totalNote += av.getCount_avis();
        }

        totalNote += avis.getCount_avis();

        // Calcul du pourcentage basé sur une note sur 5
        float percentage = ((float) totalNote / (totalAvis * 5)) * 100;
        avis.setPercentage(percentage);

        System.out.println("Nombre total d'avis : " + totalAvis);
        System.out.println("Total des notes : " + totalNote);
        System.out.println("Pourcentage : " + percentage);

        // Optionnel : mettre à jour tous les avis existants avec le nouveau total (si nécessaire)
        for (Avis av : aviss) {
            //av.setNbre_avis(totalAvis);
            av.setPercentage(percentage);
        }

        // Sauvegarde
        avisRepository.saveAll(aviss);
        avisRepository.save(avis);
        product.setPercent(avis.getPercentage());
        productRepository.save(product);
        return avis;
    }

    
    
     public Avis UpdateAvis(long id_avis,Avis avis) {
    	 
	     Avis av=GetByID(id_avis);
	     av.setCount_avis(avis.getCount_avis());
	
	   /*  List<Avis> aviss;
	     long totalNote = 0;
	     int totalAvis = aviss.size() + 1;
         for (Avis av1 : aviss) {
            totalNote += av1.getCount_avis();
         }
         float percentage = ((float) totalNote / (totalAvis * 5)) * 100;
          av.setPercentage(percentage);
          avisRepository.saveAll(aviss);*/
	
	   return avisRepository.save(av);
      }

     
     public  List<Avis> GetAllAvis() {
    	 System.out.println("get all"+avisRepository.GetAll());
    	 List<Avis> avis=avisRepository.GetAll();
    	 System.out.println("get Avis :  "+avis);
    	 return avis;
     }
     
     public List<Avis> GetFromProduct(long id_product) {
    	 Product product = productRepository.GetProductById(id_product);
    	 return avisRepository.FindByProduct(product);
     }
   
}
