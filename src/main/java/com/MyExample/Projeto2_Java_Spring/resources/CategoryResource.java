package com.MyExample.Projeto2_Java_Spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto2_Java_Spring.entities.Category;
import com.MyExample.Projeto2_Java_Spring.services.CategoryService;


@RestController 
@RequestMapping(value = "/categories")
public class CategoryResource { 

	//Declarando "Injeções de dependência"
	
	@Autowired  
	private CategoryService service;
	
	
	//Declarando de endpoints
	
	//Acessando as categorias
	@GetMapping 
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Retornando categorias pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.FindById(id);
		 return ResponseEntity.ok().body(obj);
	}
	
}
