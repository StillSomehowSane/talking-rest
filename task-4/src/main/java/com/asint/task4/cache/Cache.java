package com.asint.task4.cache;

import java.net.URL;

public class Cache {

	private Page[] cache = new Page[100];
	
	private int cachePointer = 0;
	
	/**
	 * Gets cached pages if url is found in
	 * the cache otherwise return null when
	 * the page is not found in the cache.
	 * 
	 * @param url Page URL
	 * @return Page
	 */
	public Page get(URL url) {
		
		for (Page page: this.cache) {
			if (page == null) 
				continue;
			else if (page.getUrl().equals(url))
				return page;
		}
		
		return null;
	}
	
	/**
	 * Stores a page in the cache.
	 * 
	 * @param page
	 */
	public void put(Page page) {
		
		this.cache[this.cachePointer] = page;
		++this.cachePointer;
		
		if (this.cachePointer >= this.cache.length)
			this.cachePointer = 0;
	}
}
