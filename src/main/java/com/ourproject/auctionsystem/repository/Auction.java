package com.ourproject.auctionsystem.Repo;

public class Auction {
    private int auctionId;
    private int jewelryId;
    private int userId;
    private double highestBid;
    private String status;
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public int getJewelryId() {
		return jewelryId;
	}
	public void setJewelryId(int jewelryId) {
		this.jewelryId = jewelryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getHighestBid() {
		return highestBid;
	}
	public void setHighestBid(double highestBid) {
		this.highestBid = highestBid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

   
}
