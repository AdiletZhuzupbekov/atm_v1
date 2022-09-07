package kg.megacom.atm.services.impl;

import kg.megacom.atm.mappers.NaminalMapper;
import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Balance;
import kg.megacom.atm.models.Client;
import kg.megacom.atm.models.Naminal;
import kg.megacom.atm.models.dto.NaminalDto;
import kg.megacom.atm.repository.AccountRepo;
import kg.megacom.atm.request.WithdrawalRequest;
import kg.megacom.atm.response.WithdrawalResponse;
import kg.megacom.atm.services.AccountService;
import kg.megacom.atm.services.BalanceService;
import kg.megacom.atm.services.NaminalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final BalanceService balanceService;
    private final AccountRepo accountRepo;
    private final NaminalService naminalService;
    private final NaminalMapper naminalMapper;

    public AccountServiceImpl(BalanceService balanceService, AccountRepo accountRepo, NaminalService naminalService) {
        this.balanceService = balanceService;
        this.accountRepo = accountRepo;
        this.naminalService = naminalService;
        this.naminalMapper = NaminalMapper.INSTANCE;
    }

    @Override
    public Account create(Client client,String account) {

        Balance balance = balanceService.create();

        Account newAccount = new Account();
        newAccount.setAccount(account);
        newAccount.setBalance(balance);
        newAccount.setClient(client);
        return accountRepo.save(newAccount);
    }

    @Override
    public Account refill(Long accountId, double amount) {
        Account account = accountRepo.findById(accountId).orElseThrow();
        balanceService.refill(amount, account.getBalance());

        return account;
    }

    @Override
    public List<Account> findByClient(Client client) {
        List<Account> accounts = accountRepo.findByClient(client);
        return accounts;
    }

    @Override
    public WithdrawalResponse withdraw(WithdrawalRequest withdrawalRequest) {

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();

        Account account = accountRepo.findByAccount(withdrawalRequest.getAccount());

        double rest = balanceService.getRest(account.getBalance(), withdrawalRequest.getAmount());

        List<Naminal> naminals = naminalService.withdrawCash(withdrawalRequest.getAmount());
        System.out.println(naminals);
        HashSet<NaminalDto> naminalDtos = naminalMapper.toDtos(naminals);


        withdrawalResponse.setAccount(account.getAccount());
        withdrawalResponse.setAmount(withdrawalRequest.getAmount());
        withdrawalResponse.setRest(rest);
        withdrawalResponse.setNominals(naminalDtos);

        return withdrawalResponse;
    }
}
