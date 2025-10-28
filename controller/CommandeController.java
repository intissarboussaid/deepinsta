package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Commande;
import com.deepinsta.modal.CommandeItem;
import com.deepinsta.modal.CommandeRequest;
import com.deepinsta.service.CommandeService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/commande/")
public class CommandeController {
	
	@Autowired
	private CommandeService cammandeService;
	
	@PostMapping("add/{id_product}/{id_user}")
	 public Commande AddCommande(@PathVariable("id_product") long id_product, @PathVariable("id_user")  long id_user,@RequestBody CommandeRequest commande ) throws IOException {
	    return cammandeService.addCommande(id_product, id_user, commande);
	    }
	
	@GetMapping("product/{id_cmditem}")
	 public List<Commande> getCommandesByProduct(@PathVariable("id_cmditem") long id_cmditem ) throws IOException {
	    return cammandeService.GetByCommandeProduct(id_cmditem);
	    }
	
	@GetMapping("user/{id_user}")
	 public List<Commande> getCommandesByUser(@PathVariable("id_user") long id_user ) throws IOException {
	    return cammandeService.GetCommandesByUser(id_user);
	    }
	@GetMapping("user/not/conf/{id_user}")
	 public Commande getCommandeByUserNotValidated(@PathVariable("id_user") long id_user ) throws IOException {
	    return cammandeService.GetCommandeByUserNotValidated(id_user);
	    }
	@GetMapping("get/cmd/conf/by/user/{id_user}")
	 public List<Commande> getCommandeValidatedByUser(@PathVariable("id_user") long id_user ) throws IOException {
	    return cammandeService.GetCommandeValidatedByUser(id_user);
	    }
	@GetMapping("get/cmd/conf/by/user/and/admin/{id_user}")
	 public List<CommandeItem> getCommandeValidatedByUserAndAdmin(@PathVariable("id_user") long id_user ) throws IOException {
	    return cammandeService.GetCommandeValidatedByUserAndAdmin(id_user);
	    }
	@GetMapping("get/cmd/ref/by/admin/{id_user}")
	 public List<CommandeItem> getCommandeRefusedByAdmin(@PathVariable("id_user") long id_user ) throws IOException {
	    return cammandeService.GetCommandeRefusedByAdmin(id_user);
	    }
	@GetMapping("id/{id_cmd}")
	 public Commande getCommandesById(@PathVariable("id_cmd") long id_cmd ) throws IOException {
	    return cammandeService.getById(id_cmd);
	    }
	
	@GetMapping("conf/cmd/by/user/{id_user}")
	 public Commande getAcceptedCmdByUSer(@PathVariable("id_user") long id_user ) throws IOException, MessagingException {
	    return cammandeService.validerCommandeByUser(id_user);
	    }	
	@GetMapping("get/cmds/confUser/NotConf/admin/{id_admin}")
	 public List<CommandeItem> getCmdsNotConfByAdmin(@PathVariable("id_admin") long id_admin ) throws IOException {
	    return cammandeService.GetCommandesValideByUserNotConfAdmin(id_admin);
	    }
	@GetMapping("get/cmds/valid/admin/{id_admin}")
	 public List<CommandeItem> getCmdsValidByAdmin(@PathVariable("id_admin") long id_admin ) throws IOException {
	    return cammandeService.GetCommandesValideAdmin(id_admin);
	    }
	@GetMapping("get/cmds/refused/admin/{id_admin}")
	 public List<CommandeItem> getCmdsrefusedByAdmin(@PathVariable("id_admin") long id_admin ) throws IOException {
	    return cammandeService.GetCommandesRefusedByAdmin(id_admin);
	    }
	@GetMapping("valider/cmd/admin/{id_cmditem}")
	 public CommandeItem ValiderCmdsByAdmin(@PathVariable("id_cmditem") long id_cmditem ) throws IOException, MessagingException {
	    return cammandeService.validerCommandeByAdmin(id_cmditem);
	    }
	@GetMapping("cancel/cmd/admin/{id_cmditem}")
	 public CommandeItem CancelCmdsByAdmin(@PathVariable("id_cmditem") long id_cmditem ) throws IOException, MessagingException {
	    return cammandeService.CancelCommandeByAdmin(id_cmditem);
	    }
	
	@DeleteMapping("delete/product/{id_cmditem}/{id_cmd}/{id_user}")
	 public void deleteCmdItemlong( @PathVariable("id_cmditem")  long id_cmditem,@PathVariable("id_cmd")  long id_cmd,@PathVariable("id_user")  long id_user ) throws IOException {
		cammandeService.deleteProductFromCmd(id_cmditem,id_cmd,id_user);
	    }	
	@DeleteMapping("delete/commande/{id_cmd}")
	 public void deleteCommande(@PathVariable("id_cmd")  long id_cmd ) throws IOException {
		cammandeService.deleteCommande(id_cmd);
	    }

	/*UPDATE public.commandeitem
SET is_validated_admin = 'false'
WHERE is_validated_admin IS NULL;*/

}
