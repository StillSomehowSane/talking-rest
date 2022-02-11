package com.asint.task4.cache;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Page {

	private URL url;
	
	private String content;
	
	private static Cache cache = new Cache();

	public Page(URL url) throws IOException {
		super();
		this.url = url;
		
		if (this.download()) {
			Page.cache.put(this);
		}
	}
	
	/**
	 * Handles refresh of outdated pages in the cache,
	 * manually download the requested url contents and
	 * update the page in the cache.
	 * 
	 * @param url
	 * @param refresh
	 * @throws IOException
	 */
	public Page(URL url, boolean refresh) throws IOException {
		super();
		// TODO: Implement
		this.url = url;

		if (refresh == true) {
			this.refreshMe();
		}
	}
	
	public void refreshMe() throws IOException {
		if (this.download()) {
			Page.cache.put(this);
		}
	}
	
	/**
	 * Refresh every single page in the cache by updating
	 * its contents after a fresh fetch.
	 */
	public static void refreshCache() throws IOException {
		// TODO: Implement
		for (Page p : Page.cache.getAllCachedPages()) {
			if (p != null) {
				p.refreshMe();
			}
		}
	}
	
	public static Page getPageFromCache(URL url) {
		return Page.cache.get(url);
	}

	/**
	 * Downloads contents of a page to be cached and indicates
	 * whether the page was successfully cached or not.
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	protected boolean download() throws IOException {
		
		Scanner sc = new Scanner(this.url.openStream());
		StringBuffer sb = new StringBuffer();
		
		while (sc.hasNext()) {
			sb.append(sc.next());
		}
		
		this.content = sb.toString();
	
		sc.close();
		return true;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
