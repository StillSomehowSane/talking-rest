package com.asint.task4.controller;

import java.io.IOException;
import java.net.URL;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asint.task4.cache.Page;
import com.asint.task4.cache.support.UrlWrapper;

@RestController
public class CacheController {

	@PutMapping("/scache/api/v1/add/page")
	public ResponseEntity<?> putIntoCache(@RequestBody UrlWrapper urlWrapper) {
		
		try {
			Page newPage = new Page(urlWrapper.getUrl());
			
			return new ResponseEntity<Page>(newPage, HttpStatus.CREATED);
		} catch (IOException e) {

			e.printStackTrace();
			
			return new ResponseEntity<String>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/scache/api/v1/page")
	public ResponseEntity<?> getRequestedPage(@RequestParam String url) {
		
		try {
			URL uri = new URL(url);
			Page requestedPage = Page.getPageFromCache(uri);
			
			HttpHeaders headers = new HttpHeaders();
			if (requestedPage == null) {
				headers.add("Cache-Status", "Miss From Cache");
				
				Page newPage = new Page(uri);
				
				return new ResponseEntity<Page>(newPage, headers, HttpStatus.CREATED);
			} else {
				headers.add("Cache-Status", "Hit From Cache");
				
				return new ResponseEntity<Page>(requestedPage, headers, HttpStatus.CREATED);
			}
		
		} catch (Exception r) {
			r.printStackTrace();
			
			return new ResponseEntity<String>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/scache/api/admin/all")
	public ResponseEntity<?> getAllPagesInCache() {
		// TODO: Implement
		retun null
		
	}
}
