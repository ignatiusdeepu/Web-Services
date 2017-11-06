package org.avco.business;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

	private List<String> bookList = new ArrayList<>();
	private List<String> movieList = new ArrayList<>();
	private List<String> musicList = new ArrayList<>();
	
	public ProductServiceImpl(){
		bookList.add("Book 1");
		bookList.add("Book 2");
		bookList.add("Book 3");
		
		movieList.add("Movie 1");
		movieList.add("Movie 2");
		movieList.add("Movie 3");
		
		musicList.add("Music 1");
		musicList.add("Music 2");
		musicList.add("Music 3");
	}
	
	@Override
	public List<String> getProductCategories(){
		List<String> productList = new ArrayList<String>();
		productList.add("Books");
		productList.add("Music");
		productList.add("Movies");
		return productList;
	}
	
	public List<String> getProducts(String productName){
		switch(productName){
		case "books" : return bookList;
		case "music" : return movieList;
		case "movies" : return musicList;
		}
		return null;
	}
	
	public boolean addProduct(String category,String product){
		switch(category){
		case "books" : bookList.add(product);
						return true;
		case "music" : movieList.add(product);
						return true;
		case "movies" : musicList.add(product);
						return true;
		}
		return false;
	}
}
