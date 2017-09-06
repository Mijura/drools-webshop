package com.sbz.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sbz.dto.LoginDTO;
import com.sbz.dto.RegisterDTO;
import com.sbz.dto.ResponseDTO;
import com.sbz.models.Category;
import com.sbz.models.Customer;
import com.sbz.models.Manager;
import com.sbz.models.Salesman;
import com.sbz.models.User;
import com.sbz.services.CategoryService;
import com.sbz.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) throws IllegalArgumentException, UnsupportedEncodingException {
		
		User user = service.findOneByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		
		if(user==null){
			return new ResponseEntity<ResponseDTO>(
					new ResponseDTO("Wrong username and password combination"),HttpStatus.NOT_FOUND);
		}
		
		Algorithm algorithm = Algorithm.HMAC256("sbz");
		String token=null;
		if(user instanceof Customer){
			token = createToken(algorithm, user, "customer");
		}else if(user instanceof Manager){
			token = createToken(algorithm, user, "manager");
		}else if(user instanceof Salesman){
			token = createToken(algorithm, user, "salesman");
		}
	     
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(token),HttpStatus.OK);
		
	}
	
	private String createToken(Algorithm algorithm, User user, String role) {
	
		String token = JWT.create()
		        .withClaim("username", user.getUsername())
		        .withClaim("fname", user.getFirstName())
		        .withClaim("lname", user.getLastName())
		        .withClaim("registered", user.getRegistered())
		        .withClaim("role", role)
		        .sign(algorithm);
		return token;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> register(@RequestBody RegisterDTO registerDTO) throws IllegalArgumentException, IOException {
		
		User user = service.findOneByUsername(registerDTO.getUsername());
		
		if(user!=null){
			return new ResponseEntity<ResponseDTO>(
				new ResponseDTO("Username already exist!"),HttpStatus.BAD_REQUEST);
		}
		
		Category category = categoryService.findOneByName("BRONZE");

		user = new Customer(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getFname(),
				registerDTO.getLname(), registerDTO.getAddress(), category);
		service.save(user);
		
		
		String str = registerDTO.getImage();
		
		byte[] imagedata = DatatypeConverter.parseBase64Binary(str.substring(str.indexOf(",") + 1));
		BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
		ImageIO.write(bufferedImage, "png", new File("static/images/users/"+ registerDTO.getUsername() + ".png"));
		
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(),HttpStatus.OK);
		
	}
}
