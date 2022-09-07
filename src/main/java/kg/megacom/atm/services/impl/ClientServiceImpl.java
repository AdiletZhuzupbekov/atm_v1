package kg.megacom.atm.services.impl;

import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Client;
import kg.megacom.atm.repository.ClientRepo;
import kg.megacom.atm.response.ClientResponse;
import kg.megacom.atm.services.AccountService;
import kg.megacom.atm.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final AccountService accountService;

    public ClientServiceImpl(ClientRepo clientRepo, AccountService accountService) {
        this.clientRepo = clientRepo;
        this.accountService = accountService;
    }

    @Override
    public Client create(String name) {
        Client client = new Client();
        client.setName(name);
        return clientRepo.save(client);
    }

    @Override
    public ClientResponse getAccounts(Long clientId) {
        Client client = clientRepo.findById(clientId).orElseThrow();
        List<Account> accounts = accountService.findByClient(client);
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setClient(client);
        clientResponse.setAccounts(accounts);
        return clientResponse;
    }
}
