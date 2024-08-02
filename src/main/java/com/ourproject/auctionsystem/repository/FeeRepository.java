package com.ourproject.auctionsystem.Repo;
import java.util.List;

public interface FeeRepository {
    void createFee(Fee fee);
    void updateFee(Fee fee);
    void deleteFee(int feeId);
    Fee getFeeById(int feeId);
    List<Fee> getAllFees();
	void addFee(Fee fee);
}
