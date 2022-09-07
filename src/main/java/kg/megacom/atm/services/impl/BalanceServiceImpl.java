package kg.megacom.atm.services.impl;

import kg.megacom.atm.models.Balance;
import kg.megacom.atm.repository.BalanceRepo;
import kg.megacom.atm.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepo balanceRepo;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public Balance create() {
        Balance balance = new Balance();
        balance.setBalance(0);
        balanceRepo.save(balance);
        return balance;
    }

    @Override
    public void refill(double amount, Balance balance) {
        balance.setBalance(balance.getBalance() + amount);
        balanceRepo.save(balance);
    }

    @Override
    public double getRest(Balance balance, double amount) {
        balance.setBalance(balance.getBalance()-amount);
        balanceRepo.save(balance);
        return balance.getBalance();
    }
}
