package org.avco.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.avco.business.ProductService;
import org.avco.business.ProductServiceImpl;


//@WebService annotation makes the class as a service provider.
@WebService
public class ProductCatalog {
 
	ProductService productService = new ProductServiceImpl();

	@WebMethod
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	
	@WebMethod
	public List<String> getProducts(String productName){
		return productService.getProducts(productName);
	}
	
	@WebMethod
	public boolean addProduct(String category,String product){
		return productService.addProduct(category, product);
	}
	
}
