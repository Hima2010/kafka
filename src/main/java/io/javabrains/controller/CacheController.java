package io.javabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.service.CachingService;



@RestController
public class CacheController {
	
	@Autowired
	private CachingService service;
	
	@RequestMapping("/hello")
	@Cacheable("hello")
	@CacheEvict(value="hello", allEntries=true)
	@CachePut(value="hello")
	public List<String> getListofEmployees(){
		System.out.println("this is testing cache inside getListOfEmployees block");
		return service.getList();
	}
}
