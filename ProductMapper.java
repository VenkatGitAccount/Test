package com.apple.pmsdemo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.apple.pmsdemo.model.Product;



public class ProductMapper implements RowMapper<Product> {
   public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Product product = new Product();
	   product.setProductid(rs.getLong("productid"));			  
	   product.setProductName(rs.getString("productName"));
	   product. setProductModel(rs.getString("productModel"));
	   product. setProductDescription(rs.getString("productDescription"));
	   product. setProductPrice(rs.getDouble("productPrice"));   
        
      return product;
   }
}