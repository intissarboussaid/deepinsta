package com.deepinsta.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Account;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Color_qte;
import com.deepinsta.modal.Commande;
import com.deepinsta.modal.CommandeItem;
import com.deepinsta.modal.CommandeRequest;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.CommandeItemRepository;
import com.deepinsta.repository.CommandeRepository;
import com.deepinsta.repository.ProductRepository;
import com.deepinsta.repository.UsersRepository;

import jakarta.mail.MessagingException;

@Service
public class CommandeService {
	@Autowired
	private EmailService emailService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomersService customersService;
	@Autowired
	private Colors_qte_sizeService detailsService;
	private CommandeRepository commandeRepository;	
	private ProductService productService;
	private UsersService userService;
	private ProductRepository productRepository;
	private CommandeItemRepository commandeItemRepository;
	
	public CommandeService(CommandeRepository commandeRepository,ProductService productService,UsersService userService,ProductRepository productRepository,CommandeItemRepository commandeItemRepository) {
		this.commandeRepository = commandeRepository;
		this.productService=productService;
		this.userService=userService;
		this.productRepository=productRepository;
		this.commandeItemRepository= commandeItemRepository;
	}
	
	public Commande getById(long id) {
		return commandeRepository.getById(id);
	}
	
	public Commande addCommande(long id_product , long id_user,CommandeRequest cmdRequest) {		
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);	
		Commande cmd=commandeRepository.getCmdAcceptedByUser(user, false, false);
		CommandeItem cmdItem=new CommandeItem();
		cmdItem.setProduct(product);
		cmdItem.setColor(cmdRequest.getColor());
		cmdItem.setSize(cmdRequest.getSize());		
		commandeItemRepository.save(cmdItem);
		if(cmd!=null) {
			Double total =cmd.getTotal();				
			cmd.setUser(user);				
			List<CommandeItem> cmdsItem = cmd.getCmd_item();
			cmdsItem.add(cmdItem);
			cmd.setCmd_item(cmdsItem);			
			if(product.getDiscount_price()!=0) {
				total+=product.getDiscount_price();
				cmd.setTotal(total);
				System.out.println("totla discount f cas 3andi cmd: "+total);
			}else {
				total+=product.getSale_price();
				cmd.setTotal(total);
				System.out.println("totla ma8ir discount f cas 3andi cmd: "+total);
			}
			cmd.setDate_validated_by_user(LocalDateTime.now());
			return commandeRepository.save(cmd);
		}else {
			Commande commande=new Commande();
			commande.setDate_validated_by_user(LocalDateTime.now());
			Double total =0.0;
			List<CommandeItem> cmdsItem = new ArrayList<>();
			cmdsItem.add(cmdItem);
			commande.setCmd_item(cmdsItem);
			commande.setUser(user);
			if(product.getDiscount_price()!=0) {
				total+=product.getDiscount_price();
				commande.setTotal(total);
				System.out.println("totla b discount f cas ma3andich cmd: "+total);
			}else {
				total+=product.getSale_price();
				commande.setTotal(total);
				System.out.println("totla m8ir discount f cas m3andich cmd: "+total);
			}
			return commandeRepository.save(commande);
		}
		
		
	}
	
	public List<Commande> GetByCommandeProduct(long id_cmdItem){
		CommandeItem cmdItem=commandeItemRepository.findById(id_cmdItem);
		List<Commande> commandes=commandeRepository.findByProduct(cmdItem);
		return commandes;
		
		
	}
	public List<Commande> GetCommandesByUser(long id_user){
		Users user=userService.FindUserByID(id_user);
		List<Commande> commandes=commandeRepository.findByUser(user);
		return commandes;	
	}
	
	public Commande GetCommandeByUserNotValidated(long id_user){
		Users user=userService.FindUserByID(id_user);
		Commande commandes=commandeRepository.getCmdAcceptedByUser(user,false,false);
		return commandes;	
	}
	public List<Commande> GetCommandeValidatedByUser(long id_user){
		Users user=userService.FindUserByID(id_user);
		List<Commande> commandes=commandeRepository.getCmdsAcceptedByUser(user,true,false);
		return commandes;	
	}
	public List<CommandeItem> GetCommandeValidatedByUserAndAdmin(long id_user){
		Users user=userService.FindUserByID(id_user);
		List<Commande> commandes=commandeRepository.findByUser(user);
		List<CommandeItem> commandesItem =new ArrayList<>();
		for(Commande commande : commandes) {
			for(CommandeItem cmdItem: commande.getCmd_item()) {
				if(cmdItem.isIs_validated_admin()) {
					commandesItem.add(cmdItem);					
				}
			}
		}
		return commandesItem;	
	}
	
	public List<CommandeItem> GetCommandeRefusedByAdmin(long id_user){
		Users user=userService.FindUserByID(id_user);
		List<Commande> commandes=commandeRepository.findByUser(user);
		List<CommandeItem> commandesItem =new ArrayList<>();
		for(Commande commande : commandes) {
			for(CommandeItem cmdItem: commande.getCmd_item()) {
				if(!cmdItem.isIs_validated_admin() && cmdItem.getDate_conf_by_admin()!=null) {
					commandesItem.add(cmdItem);	
					
				}
			}
		}
		return commandesItem;	
	}
	public Commande validerCommandeByUser(long id_user) throws MessagingException {
		Users user=userService.FindUserByID(id_user);
		Commande commandes=commandeRepository.getCmdAcceptedByUser(user,false,false);
		System.out.println("commande: "+ commandes);
		System.out.println("commande items: "+ commandes.getCmd_item());
		commandes.getCmd_item();
		for(CommandeItem cmdItem :commandes.getCmd_item()) {
			Admin admin =cmdItem.getProduct().getAdmin();
			Account account = accountService.getAccountByAdmin(admin);
			String subject = admin.getNom()+ admin.getPrenom()+", you've got a new order!";
			String htmlBody = "<!DOCTYPE html>" +
				    "<html>" +
				    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
				    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
				    "    <tr>" +
				    "      <td align='center'>" +
				    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
				    "          <tr>" +
				    "            <td style='text-align: center; font-size: 28px; font-weight: bold; color: #5a3c28;'> YOU'VE GOT A NEW ORDER</td>" +
				    "          </tr>" +
				    "          <tr>" +
				    "            <td style='text-align: center; padding: 30px 0; width:100%;'> We wanted to inform you that there is a new order in the system that requires your attention. Please take a moment to review it at your earliest convenience" +
				    "            </td>" +
				    "          </tr>" +
				    "          <tr>" +
				    "            <td style='text-align: center; font-size: 18px; color: #5a3c28;'>If you need any additional details or support regarding this order, feel free to reach out.</td>" +
				    "          </tr>" +
				    "        </table>" +
				    "      </td>" +
				    "    </tr>" +
				    "  </table>" +
				    "</body>" +
				    "</html>";
			
			
			emailService.sendHtmlEmail(account.getEmail(), subject, htmlBody);
		}
		
		
		
		commandes.setIs_validated_user(true);
		commandes.setDate_validated_by_user(LocalDateTime.now());
		
		return commandeRepository.save(commandes);
	}
	public List<CommandeItem> GetCommandesValideByUserNotConfAdmin(long id_admin){
		List<Product>products = productService.GetProductsByAdmin(id_admin);
		List<Commande> commandes=commandeRepository.getCmdsConfByUserAndNotByAdmin(true,false);
		List<CommandeItem>cmds =new ArrayList<>();
		for(Product product:products) {
			for(Commande commande: commandes) {
				for(CommandeItem cmdItem:commande.getCmd_item()) {
					if(cmdItem.getProduct()==product && cmdItem.getDate_conf_by_admin()==null) {
						cmds.add(cmdItem);
					}
				}
			}
		}
		
		return cmds;
	}
	public List<CommandeItem> GetCommandesValideAdmin(long id_admin){
		List<Product>products = productService.GetProductsByAdmin(id_admin);
		List<Commande> commandes=commandeRepository.getCmdsConfByUserAndNotByAdmin(true,false);
		List<CommandeItem>cmds =new ArrayList<>();
		for(Product product:products) {
			for(Commande commande: commandes) {
				for(CommandeItem cmdItem:commande.getCmd_item()) {
					if(cmdItem.getProduct()==product && cmdItem.isIs_validated_admin()) {
						cmds.add(cmdItem);
					}
				}
			}
		}
		
		return cmds;
	}
	public List<CommandeItem> GetCommandesRefusedByAdmin(long id_admin){
		List<Product>products = productService.GetProductsByAdmin(id_admin);
		List<Commande> commandes=commandeRepository.getCmdsConfByUserAndNotByAdmin(true,false);
		List<CommandeItem>cmds =new ArrayList<>();
		for(Product product:products) {
			for(Commande commande: commandes) {
				for(CommandeItem cmdItem:commande.getCmd_item()) {
					if(cmdItem.getProduct()==product && !cmdItem.isIs_validated_admin()) {
						cmds.add(cmdItem);
					}
				}
			}
		}
		
		return cmds;
	}
	public CommandeItem validerCommandeByAdmin(long id_cmdItem) throws MessagingException {
		CommandeItem cmd=commandeItemRepository.findById(id_cmdItem);
		cmd.setIs_validated_admin(true);
		cmd.setDate_conf_by_admin(LocalDateTime.now());
		Users user ;
		int quantity=cmd.getProduct().getQte();
		quantity--;
		if(quantity==0) {
			String status="Out of Stock";
			cmd.getProduct().setStatus(status);
		}
		List<Color_qte> details=cmd.getProduct().getColor_size_qte();
		for(Color_qte detail : details) {
			System.out.println("color" + cmd.getColor());
			if(cmd.getColor().equals(detail.getColor())) {
				System.out.println("the colors are similaire"+ detail.getColor()+"cmd color"+ cmd.getColor());
			}
			System.out.println("size" + cmd.getSize() );
			if(cmd.getColor().equals(detail.getColor())) {
				if(cmd.getSize()!=null) {
					System.out.println("test size" + detail.getSize());
				}
				int qte = detail.getRest_qte();
				System.out.println("id details" + detail.getId_cq());
				qte --;
				detail.setRest_qte(qte);
				if(detail.getRest_qte()==0) {
					detail.setColor(null);
					detail.setSize(null);
					detailsService.save(detail);					
				}
			}
		}
		cmd.getProduct().setRest_qte(quantity);
		
		int nbreCmd=cmd.getProduct().getNbre_cmd();
		nbreCmd++;
		cmd.getProduct().setNbre_cmd(nbreCmd);
		List<Commande> commandes = commandeRepository.findByProduct(cmd);
		for(Commande commande:commandes) {
			Account account = accountService.getAccountByUser(commande.getUser());
			String subject = commande.getUser().getNom()+ commande.getUser().getPrenom()+", We're happy to inform you that your order has been confirmed.";
			String htmlBody = "<!DOCTYPE html>" +
				    "<html>" +
				    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
				    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
				    "    <tr>" +
				    "      <td align='center'>" +
				    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
				    "          <tr>" +
				    "            <td style='text-align: center; font-size: 28px; font-weight: bold; color: #5a3c28;'> Your order couldn't be validated at this time.</td>" +
				    "          </tr>" +
				    "          <tr>" +
				    "            <td style='text-align: center; padding: 30px 0; width:100%;'>Your order has been successfully confirmed and is currently on its way. Thank you for choosing us!" +
				    "            </td>" +
				    "          </tr>" +
				    "        </table>" +
				    "      </td>" +
				    "    </tr>" +
				    "  </table>" +
				    "</body>" +
				    "</html>";
			
			
			emailService.sendHtmlEmail(account.getEmail(), subject, htmlBody);
			customersService.AddCustomersByAdmin(cmd.getProduct().getAdmin(), commande.getUser());
			
		}		
return commandeItemRepository.save(cmd);
	}
	public CommandeItem CancelCommandeByAdmin(long id_cmdItem) throws MessagingException {
		CommandeItem cmd=commandeItemRepository.findById(id_cmdItem);
		cmd.setIs_validated_admin(false);
		cmd.setDate_conf_by_admin(LocalDateTime.now());	
		List<Commande> commandes = commandeRepository.findByProduct(cmd);
		for(Commande commande:commandes) {
			Account account = accountService.getAccountByUser(commande.getUser());
			String subject = commande.getUser().getNom()+ commande.getUser().getPrenom()+", We're sorry, but we were unable to validate your order.";
			String htmlBody = "<!DOCTYPE html>" +
				    "<html>" +
				    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
				    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
				    "    <tr>" +
				    "      <td align='center'>" +
				    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
				    "          <tr>" +
				    "            <td style='text-align: center; font-size: 28px; font-weight: bold; color: #5a3c28;'> Your order couldn't be validated at this time.</td>" +
				    "          </tr>" +
				    "          <tr>" +
				    "            <td style='text-align: center; padding: 30px 0; width:100%;'>Unfortunately, we were unable to validate your order. Please review the details and try again, or contact support if you need assistance." +
				    "            </td>" +
				    "          </tr>" +
				    "        </table>" +
				    "      </td>" +
				    "    </tr>" +
				    "  </table>" +
				    "</body>" +
				    "</html>";
			
			
			emailService.sendHtmlEmail(account.getEmail(), subject, htmlBody);
		}
		return commandeItemRepository.save(cmd);
	}
	public Commande  deleteProductFromCmd(long id_cmditem, long id_cmd, long id_user) {
		Users user =userService.FindUserByID(id_user);
		CommandeItem productToRemove = commandeItemRepository.findById(id_cmditem);	
		Commande commande =commandeRepository.getCmdByUserAndProduct(user,productToRemove,false,false);
		Double Total=commande.getTotal();
		if(productToRemove.getProduct().getDiscount_price()!=0.0) {
			Total-=productToRemove.getProduct().getDiscount_price();
			commande.setTotal(Total);
		}else {
			Total-=productToRemove.getProduct().getSale_price();
			commande.setTotal(Total);
		}
		commande.getCmd_item().remove(productToRemove);
		 commandeRepository.save(commande);
				return commande;
		
	}
	
	public void  deleteCommande(long id_cmd) {
		Commande commande =commandeRepository.getById(id_cmd);
		if(commande.getCmd_item().size()==0) {
			commandeRepository.delete(commande);
		}
		
	}


}
