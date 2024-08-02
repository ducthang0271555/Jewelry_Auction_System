package com.ourproject.auctionsystem.Repo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeeRepositoryImpl implements FeeRepository {
    private List<Fee> fees = new ArrayList<>();

    @Override
    public void createFee(Fee fee) {
        fees.add(fee);
    }

    @Override
    public void addFee(Fee fee) {
        fees.add(fee); 
    }

    @Override
    public void updateFee(Fee fee) {
        Optional<Fee> existingFeeOpt = fees.stream()
                                           .filter(f -> f.getFeeId() == fee.getFeeId())
                                           .findFirst();
        if (existingFeeOpt.isPresent()) {
            Fee existingFee = existingFeeOpt.get();
            existingFee.setFeeType(fee.getFeeType());
            existingFee.setAmount(fee.getAmount());
        }
    }

    @Override
    public void deleteFee(int feeId) {
        fees.removeIf(fee -> fee.getFeeId() == feeId);
    }

    @Override
    public Fee getFeeById(int feeId) {
        return fees.stream()
                   .filter(fee -> fee.getFeeId() == feeId)
                   .findFirst()
                   .orElse(null);
    }

    @Override
    public List<Fee> getAllFees() {
        return new ArrayList<>(fees);
    }
}
