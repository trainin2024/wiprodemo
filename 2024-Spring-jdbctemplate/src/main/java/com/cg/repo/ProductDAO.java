package com.cg.repo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.model.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  //-----------Retrieve---------------------
	
	private org.springframework.jdbc.core.RowMapper<Product> rowMapper = (ResultSet rs, int rowNum)->{
		Product product = new Product();
		product.setId(rs.getInt(1));
		product.setPname(rs.getString(2));
		product.setPrice(rs.getInt(3));
		return product;
	};
	  
	public List<Product> getAllProducts()
	{ return jdbcTemplate.query("select * from product", rowMapper);  }
	
	public int saveProduct(Product e){  
		System.out.println(e.toString());
	    String query="insert into Product values( '"+e.getId()+"','"+e.getPname()+"','"+(int)e.getPrice()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int updateProduct(Product e){  
		System.out.println(" I am in dao");
	    String query="update Product  set   pname='"+e.getPname()+"',price='"+(int)e.getPrice()+"' where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int deleteProduct(int id){  
		System.out.println("Id:"+id);
	    String query="delete from product where id='"+id+"' ";  
	    System.out.println(query);
	    return jdbcTemplate.update(query);  
	}  
	
	public Optional<Product> findbyId(int id) 
	{
		 String sql="select * from product where id='"+id+"' "; 
		 Optional<Product> product= jdbcTemplate.query(sql,rowMapper)
		           .stream()
		           .findFirst();
		 return product;
		       
	}

}
