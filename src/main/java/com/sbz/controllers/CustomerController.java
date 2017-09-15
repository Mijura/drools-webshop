package com.sbz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbz.dto.CartDTO;
import com.sbz.jwt.JWTVerify;
import com.sbz.models.Article;
import com.sbz.models.Customer;
import com.sbz.models.Item;
import com.sbz.models.Receipt;
import com.sbz.services.ArticleService;
import com.sbz.services.CustomerService;
import com.sbz.services.ReceiptService;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

	@Autowired
	private ArticleService service;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private KieContainer kieContainer;
	
	@RequestMapping(value = "/getReceipts", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Receipt>> getReceipts(@CookieValue("token") String token) {
		String username;
		if ( (username = JWTVerify.verifyAndGetUsername(token, "customer"))!=null){
			Customer c = customerService.findOneByUsername(username);
			List<Receipt> receipts = receiptService.findByCustomer(c);
			return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Receipt>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getReceipt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Receipt> getReceipt(@CookieValue("token") String token, 
			@RequestBody CartDTO c) {
	
		if (JWTVerify.verify(token, "customer")){
			
			Receipt receipt = receiptService.findOne(c.getId());
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getArticles", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Article>> getArticles(@CookieValue("token") String token) {
		
		if (JWTVerify.verify(token, "customer")){
			List<Article> articles = service.findAllByStatus("ACTIVE");
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Article>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getDiscounts", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Receipt> getDiscounts(@CookieValue("token") String token, 
			@RequestBody List<CartDTO> cart) {
		String username;
		if ( (username = JWTVerify.verifyAndGetUsername(token, "customer"))!=null){
			Customer customer = customerService.findOneByUsername(username);
			Receipt receipt = new Receipt();
			receipt.setCustomer(customer);
			List<Item> items = new ArrayList<Item>();
			double price =0;
			for(CartDTO x:cart){
				Article article = service.findOne(x.getId());
				Item it = new Item(article, x.getAmount());
				items.add(it);
				price = price + it.getTotalPrice();
			}
			receipt.setItems(items);
			receipt.setTotalPrice(price);
			
			KieSession kieSession = kieContainer.newKieSession("session");
			kieSession.insert(receipt);
			kieSession.getAgenda().getAgendaGroup("items").setFocus();
			kieSession.fireAllRules();
			
			kieSession.getAgenda().getAgendaGroup("receipt").setFocus();
			kieSession.fireAllRules();
			
			kieSession.getAgenda().getAgendaGroup("points").setFocus();
			kieSession.fireAllRules();
			
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping(value = "/createReceipt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> createReceipt(@CookieValue("token") String token, 
			@RequestBody Receipt receipt) {
		String username;
		if ((username = JWTVerify.verifyAndGetUsername(token, "customer"))!=null){
			Customer customer = customerService.findOneByUsername(username);
			customer.getReceipts().add(receipt);
			receipt.setCustomer(customer);
			receiptService.save(receipt);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
