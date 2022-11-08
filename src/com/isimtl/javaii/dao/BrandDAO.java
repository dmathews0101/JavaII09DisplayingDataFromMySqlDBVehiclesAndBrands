package com.isimtl.javaii.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.isimtl.javaii.model.Brands;
import com.isimtl.javaii.model.ShopFactory;
import com.isimtl.javaii.model.Vehicles;

public class BrandDAO extends ShopDAO{
		
	public List<Brands> getAllBrands() throws Exception
	{
		List<Brands> brands = new ArrayList<>();
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM brands";
		
		ResultSet rs = stmt.executeQuery(query);
		
		Brands brand;
		
		while(rs.next())
		{
			brand = new Brands();
			ShopFactory.buildBrand(rs,brand);
			brands.add(brand);
		}		
		connection.close();				
		return brands;
	}
	
	public static void main(String[] args) throws Exception {
		
		BrandDAO brandDAO = new BrandDAO();
		List<Brands> brands = brandDAO.getAllBrands();
		
		for(Brands brand:brands)
		{
			System.out.println(brand);
		}		
	}

}
