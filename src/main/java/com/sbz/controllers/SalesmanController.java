package com.sbz.controllers;

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
import com.sbz.dto.NewDTO;
import com.sbz.jwt.JWTVerify;
import com.sbz.models.Article;
import com.sbz.models.Receipt;
import com.sbz.services.ArticleService;
import com.sbz.services.ReceiptService;

@RestController
@RequestMapping(value = "/api/salesman")
public class SalesmanController {
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private KieContainer kieContainer;

	@RequestMapping(value = "/getAllReceipts", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Receipt>> getAllReceipts(@CookieValue("token") String token) {
		if ( JWTVerify.verifyAndGetUsername(token, "salesman")!=null){
			List<Receipt> receipts = receiptService.findAll();
			return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Receipt>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/fillingTheStock", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Article>> fillingTheStock(@CookieValue("token") String token) {
		if ( JWTVerify.verifyAndGetUsername(token, "salesman")!=null){
			List<Article> articles = articleService.findAllByStatus("ACTIVE");
			KieSession kieSession = kieContainer.newKieSession("session");
			
			
			for(int i=0; i<articles.size(); i++){
				kieSession.insert(articles.get(i));
			}
			
			kieSession.getAgenda().getAgendaGroup("articles").setFocus();
			kieSession.fireAllRules();
			
			for(int i=0; i<articles.size(); i++){
				articleService.save(articles.get(i));
			}
			
			articles = articleService.findAllByOrdered(true);
			
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Article>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getReceipt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Receipt> getReceipt(@CookieValue("token") String token, 
			@RequestBody CartDTO c) {
	
		if (JWTVerify.verify(token, "salesman")){
			
			Receipt receipt = receiptService.findOne(c.getId());
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/acceptReceipt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Receipt> acceptReceipt(@CookieValue("token") String token, 
			@RequestBody CartDTO c) {
	
		if (JWTVerify.verify(token, "salesman")){
			
			Receipt receipt = receiptService.findOne(c.getId());
			receipt.setState("SUCCESS");
			receipt.getCustomer().setPoints(receipt.getCustomer().getPoints()+receipt.getEarnedPoints());
			receiptService.save(receipt);
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/declineReceipt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Receipt> declineReceipt(@CookieValue("token") String token, 
			@RequestBody CartDTO c) {
	
		if (JWTVerify.verify(token, "salesman")){
			
			Receipt receipt = receiptService.findOne(c.getId());
			receipt.setState("CANCELED");
			receipt.getCustomer().setPoints(receipt.getCustomer().getPoints()+receipt.getSpentPoints());
			receiptService.save(receipt);
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/setNewValue", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Article> setNewValue(@CookieValue("token") String token, 
			@RequestBody NewDTO n) {
	
		if (JWTVerify.verify(token, "salesman")){
			
			Article a = n.getArticle();
			a.setCount(n.getNewValue());
			a.setOrdered(false);
			articleService.save(a);
			return new ResponseEntity<Article>(a, HttpStatus.OK);
		}else{
			return new ResponseEntity<Article>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
