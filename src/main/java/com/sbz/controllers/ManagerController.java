package com.sbz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbz.jwt.JWTVerify;
import com.sbz.models.ArticleCategory;
import com.sbz.models.Category;
import com.sbz.models.SpendingLimit;
import com.sbz.services.ArticleCategoryService;
import com.sbz.services.CategoryService;
import com.sbz.services.SpendingLimitService;

@RestController
@RequestMapping(value = "/api/manager")
public class ManagerController {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	@Autowired
	private SpendingLimitService sLService;
	
	@RequestMapping(value = "/getCategories", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Category>> getCategories(@CookieValue("token") String token) {
		
		if (JWTVerify.verify(token, "manager")){
			List<Category> categories = service.findAll();
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getArticleCategories", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<ArticleCategory>> getArticleCategories(@CookieValue("token") String token) {
		
		if (JWTVerify.verify(token, "manager")){
			List<ArticleCategory> categories = articleCategoryService.findAll();
			return new ResponseEntity<List<ArticleCategory>>(categories, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<ArticleCategory>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/editArticleCategories", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<ArticleCategory>> editArticleCategories(@CookieValue("token") String token, @RequestBody ArticleCategory articleCategory) {
		
		if (JWTVerify.verify(token, "manager")){
			articleCategoryService.save(articleCategory);
			List<ArticleCategory> categories = articleCategoryService.findAll();
			return new ResponseEntity<List<ArticleCategory>>(categories, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<ArticleCategory>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/addArticleCategories", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<ArticleCategory>> addArticleCategories(@CookieValue("token") String token, @RequestBody ArticleCategory articleCategory) {
		
		if (JWTVerify.verify(token, "manager")){
			ArticleCategory ac = articleCategoryService.findOneById(articleCategory.getId());
			if(ac!=null)
				return new ResponseEntity<List<ArticleCategory>>(HttpStatus.OK);
			
			articleCategoryService.save(articleCategory);
			List<ArticleCategory> categories = articleCategoryService.findAll();
			return new ResponseEntity<List<ArticleCategory>>(categories, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<ArticleCategory>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/changeCustomerCategories", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> changeCustomerCategories(@CookieValue("token") String token, @RequestBody List<SpendingLimit> limits ) {
		
		if (JWTVerify.verify(token, "manager")){
			sLService.saveAll(limits);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
