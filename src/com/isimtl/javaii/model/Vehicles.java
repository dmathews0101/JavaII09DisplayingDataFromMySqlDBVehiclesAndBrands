package com.isimtl.javaii.model;

public class Vehicles {
	private int nb;
	private String model;
	private int year;
	private double price;
	
	private Brands brand;

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Vehicles [nb=" + nb + ", model=" + model + ", year=" + year + ", price=" + price + ", brand=" + brand
				+ "]";
	}

}

