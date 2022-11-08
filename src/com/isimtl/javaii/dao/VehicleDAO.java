package com.isimtl.javaii.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.isimtl.javaii.model.ShopFactory;
import com.isimtl.javaii.model.Vehicles;

public class VehicleDAO extends ShopDAO{
	

	public List<Vehicles> getAllVehicles() throws Exception
	{
		List<Vehicles> vehicles = new ArrayList<>();
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM vehicles";
		
		ResultSet rs = stmt.executeQuery(query);
		
		Vehicles vehicle;
		
		while(rs.next())
		{
			vehicle = new Vehicles();
			ShopFactory.buildVehicles(rs,vehicle);
			vehicles.add(vehicle);
		}
		
		for(Vehicles currentVehicle:vehicles)
		{
			ShopFactory.buildBrand(connection,currentVehicle.getBrand());
		}
		connection.close();
		return vehicles;
	}
	
	
	public List<Vehicles> getSelectedVehicle(int id) throws Exception
	{
		List<Vehicles> vehicles = new ArrayList<>();
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM vehicles where brandID = '"+id+"'";

		ResultSet rs = stmt.executeQuery(query);
		
		Vehicles vehicle;
		
		while(rs.next())
		{
			vehicle = new Vehicles();
			ShopFactory.buildVehicles(rs,vehicle);
			vehicles.add(vehicle);
		}
		
		for(Vehicles currentVehicle:vehicles)
		{
			ShopFactory.buildBrand(connection,currentVehicle.getBrand());
		}
		connection.close();
		return vehicles;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		VehicleDAO vehicleDAO = new VehicleDAO();
		List<Vehicles> vehicles = vehicleDAO.getAllVehicles();
		
		for(Vehicles vehicle:vehicles)
		{
			System.out.println(vehicle);
		}		
	}


}
