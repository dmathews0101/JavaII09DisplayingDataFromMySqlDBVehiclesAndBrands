package com.isimtl.javaii.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopFactory {
	
//	`nb`, `model`, `yr`, `price`, `brand_id`
	public static void  buildVehicles(ResultSet rs,Vehicles vehicle) throws SQLException
	{
		Brands brand;
		
		vehicle.setNb(rs.getInt("nb"));
		vehicle.setModel(rs.getString("model"));
		vehicle.setYear(rs.getInt("yr"));
		vehicle.setPrice(rs.getDouble("price"));
		
		brand = new Brands();
		brand.setBrand_id(rs.getInt("brandID"));
		
		vehicle.setBrand(brand);
	}
//	`brandID`,`brand`
	public static void buildBrand(ResultSet rs, Brands brand) throws SQLException
	{
		brand.setBrand_id(rs.getInt("brandID"));
		brand.setBrand_name(rs.getString("brand"));
	}
	
	public static void buildBrand(Connection connection, Brands brand) throws SQLException {
		
		if (null == brand.getBrand_name())
		{
			Statement stmt = connection.createStatement();
			
			String query = "SELECT brand FROM brands WHERE brandID = "+ brand.getBrand_id();
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
			{
				brand.setBrand_name(rs.getString("brand"));
			}
		}
		
	}

}
