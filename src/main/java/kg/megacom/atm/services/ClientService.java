package kg.megacom.atm.services;

import kg.megacom.atm.models.Client;
import kg.megacom.atm.response.ClientResponse;

public interface ClientService {
    Client create(String name);

    ClientResponse getAccounts(Long clientId);
}
