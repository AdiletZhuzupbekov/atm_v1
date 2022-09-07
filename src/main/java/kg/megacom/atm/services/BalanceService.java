package kg.megacom.atm.services;

import kg.megacom.atm.models.Balance;

public interface BalanceService {
    Balance create();

    void refill(double amount, Balance balance);

    double getRest(Balance balance, double amount);
}
