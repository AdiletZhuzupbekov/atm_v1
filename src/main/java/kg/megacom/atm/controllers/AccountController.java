package kg.megacom.atm.controllers;

import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Client;
import kg.megacom.atm.request.WithdrawalRequest;
import kg.megacom.atm.response.WithdrawalResponse;
import kg.megacom.atm.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create-account")
    Account create(@RequestBody Client client, String account){
        return accountService.create(client, account);
    }
    @PostMapping("/account-refill")
    Account refill(@RequestParam Long accountId, double amount){
        return accountService.refill(accountId, amount);
    }

    @PostMapping("/withdraw")
    WithdrawalResponse withdrawal(@RequestBody WithdrawalRequest withdrawalRequest){
        return accountService.withdraw(withdrawalRequest);
    }
}
