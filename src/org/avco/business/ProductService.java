package org.avco.business;

import java.util.List;

public interface ProductService {

	public List<String> getProductCategories();
	
	public List<String> getProducts(String productName);
	
	public boolean addProduct(String category,String product);
}
