package com.apple.pmsdemo.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apple.pmsdemo.model.Product;

@Repository
public class ProductDao {
  @Autowired
	JdbcTemplate jdbcTemplate;

	//create
	public Long createProduct(Product product) {
		//logger.info("***create Product***");		
		String createProductQuery="insert into Product(productid,productName,productModel,ProductDescription,ProductPrice) values(?,?,?,?,?)";
		jdbcTemplate.update( createProductQuery, product.getProductid(), product.getProductName(),product.getProductModel(),product.getProductDescription(),product.getProductPrice());
		return product.getProductid();
	}	
	//get
	public Product getProduct(long productId)
	{
		String getProductQuery= "select * from product where productid=?";		
	      Product product = jdbcTemplate.queryForObject(getProductQuery,  new Object[]{productId}, new ProductMapper());	      
	      return product;		
	}
	//get all products
	public List <Product> getAllProducts()
	{
		String getAllProductQuery = "select * from Product";
	      List <Product> products = jdbcTemplate.query(getAllProductQuery, new ProductMapper());
	      return products;		
	}
	//update product
	public Product updateProduct(Product product)
	{
		String updateProductQuery = "update Product set productName = ?, productModel=?, ProductDescription=?, ProductPrice=? where productid = ?";
		jdbcTemplate.update(updateProductQuery, product.getProductName(), product.getProductModel(), product.getProductDescription(),product.getProductPrice(),product.getProductid());
	      //System.out.println("Updated Record with ID = " + product.getProductid() );
	      return product;
	}
	//Delete
	public Long deleteProduct(long productId) {
		String deleteProductQuery = "delete from Product where id = ?";
		jdbcTemplate.update(deleteProductQuery, productId);
	    //  System.out.println("Deleted Record with ID = " + id );
	      return productId; 
	}
}
