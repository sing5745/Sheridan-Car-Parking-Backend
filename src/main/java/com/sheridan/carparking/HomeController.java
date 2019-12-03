package com.sheridan.carparking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@RestController
@CrossOrigin({"http://localhost:3000", "http://192.168.0.27:3000"})
public class HomeController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/home")
	public String home() {
		String test = "[{\"0\":\"1\",\"ID\":\"1\",\"1\":\"Inder\",\"Name\":\"Inder\",\"2\":\"10 lang Dr.\",\"Address\":\"10 lang Dr.\",\"3\":\"ij@sheridan.ca\",\"Email\":\"inder@springboot.com\",\"4\":\"100000\",\"Salary\":\"100000\"},{\"0\":\"2\",\"ID\":\"2\",\"1\":\"Inderpreet Singh\",\"Name\":\"Inderpreet Singh\",\"2\":\"Financial Dr.\",\"Address\":\"Financial Dr.\",\"3\":\"isingh@russelmetals.com\",\"Email\":\"isingh@russelmetals.com\",\"4\":\"120000\",\"Salary\":\"120000\"},{\"0\":\"3\",\"ID\":\"3\",\"1\":\"IJ Singh\",\"Name\":\"IJ Singh\",\"2\":\"Russel Lane\",\"Address\":\"Russel Lane\",\"3\":\"ij@home.ca\",\"Email\":\"ij@home.ca\",\"4\":\"150000\",\"Salary\":\"150000\"},{\"0\":\"4\",\"ID\":\"4\",\"1\":\"Mr. Kirk\",\"Name\":\"Mr. Kirk\",\"2\":\"Enterprise Ct.\",\"Address\":\"Enterprise Ct.\",\"3\":\"kirk@james.ca\",\"Email\":\"kirk@james.ca\",\"4\":\"230000\",\"Salary\":\"230000\"}]";
		
		User user = new User();
		user.setUserName("Inder");
		user.setPassword("password");
		
		repo.save(user);
		
		return "{\n" + 
				"    \"number\": 89,\n" + 
				"    \"lastEntry\": \"19 November 2019 8:30 AM\",\n" + 
				"    \"lastEntryBy\": \"isingh\",\n" + 
				"    \"lastStore\": \"2567\",\n" + 
				"    \"lastExcelSubmitted\": \"SIA-68-B2567\"\n" + 
				"}";
	}
	
	@PostMapping("/api/submit")
	public String add(@RequestBody JsonNode name) {
		
		System.out.println(name);
		
		return "[{\"0\":\"Jason\",\"name\":\"Jason\",\"1\":\"10000\",\"score\":\"10000\"},{\"0\":\"Yoda\",\"name\":\"Yoda\",\"1\":\"1000\",\"score\":\"1000\"},{\"0\":\"Inderpreet\",\"name\":\"Inderpreet\",\"1\":\"110\",\"score\":\"110\"}]";
	}
	
	@PostMapping("/submit")
	@ResponseStatus(HttpStatus.OK)
	public String addUser(@RequestBody JsonNode  user) throws FileNotFoundException
	{
		File file = ResourceUtils.getFile("classpath:/static/Test.txt");
		
		System.out.println(user);
		return file.getName();
	}
	

}
