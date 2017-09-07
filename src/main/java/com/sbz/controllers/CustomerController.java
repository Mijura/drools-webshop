package com.sbz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbz.jwt.JWTVerify;
import com.sbz.models.Article;
import com.sbz.services.ArticleService;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

	@Autowired
	private ArticleService service;
	
	@RequestMapping(value = "/getArticles", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Article>> getCategories(@CookieValue("token") String token) {
		
		if (JWTVerify.verify(token, "customer")){
			List<Article> articles = service.findAllByStatus("ACTIVE");
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Article>>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
