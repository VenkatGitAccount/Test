package com.apple.pmsdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.apple.pmsdemo.dao.ProductDao;
import com.apple.pmsdemo.model.Product;

@RestController
//@Controller
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
	
	ProductDao productDao= new ProductDao();
	
	@POST	
	public Long createProduct(Product product) {
		//logger.info("***create Product***");
		return productDao.createProduct(product) ;		
	}
		
	@GET
	@Path("/{id}")
	public Product getProduct(@PathParam("id") long productId) 
	{
		//logger.info("getProduct ID="+productId);		
		return productDao.getProduct(productId);
	}
	
	@GET
	public List<Product> getAllProducts()
	{
		//Getting all products
		return productDao.getAllProducts();
	}
	
	//  /product
	@PUT
	@Path("/{id}")
	public Product updateProduct(@PathParam("id") long productId , Product product) 
	{
		product.setProductid(productId);
		return productDao.updateProduct(product);
	}
	
	//delete
	//  / product/{id}
	@DELETE
	@Path("/{id}")
	public Long deleteProduct(@PathParam("id") long productId)
	{
		return  productDao.deleteProduct(productId);
	}
	//delete
	//  / product/{id}
	@DELETE
	@Path("/{number}")
	public Long deleteProduct(@PathParam("number") long productNumber)
	{
		return  productDao.deleteProduct(productNumber);
	}
}
