package kg.megacom.atm.response;

import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Client;
import lombok.Data;

import java.util.List;

@Data
public class ClientResponse {
    private Client client;
    private List<Account> accounts;
}
