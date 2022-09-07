package kg.megacom.atm.controllers;

import kg.megacom.atm.models.Client;
import kg.megacom.atm.response.ClientResponse;
import kg.megacom.atm.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    Client create(@RequestParam String name){
        return clientService.create(name);
    }


    @GetMapping("/info")
    ClientResponse getAccounts(@RequestParam Long clientId){
        return clientService.getAccounts(clientId);
    }
}
