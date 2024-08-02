package com.ourproject.auctionsystem.Repo;

public class Jewelry {
    private int jewelryId;
    private String name;
    private String description;
    private double startingPrice;
	public int getJewelryId() {
		return jewelryId;
	}
	public void setJewelryId(int jewelryId) {
		this.jewelryId = jewelryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getStartingPrice() {
		return startingPrice;
	}
	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}

   
}
