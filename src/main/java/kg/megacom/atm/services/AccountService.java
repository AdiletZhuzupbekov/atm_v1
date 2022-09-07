package kg.megacom.atm.services;

import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Client;
import kg.megacom.atm.request.WithdrawalRequest;
import kg.megacom.atm.response.WithdrawalResponse;

import java.util.List;

public interface AccountService {
    Account create(Client client, String account);

    Account refill(Long accountId, double amount);

    List<Account> findByClient(Client client);

    WithdrawalResponse withdraw(WithdrawalRequest withdrawalRequest);

}
