package kg.megacom.atm.repository;

import kg.megacom.atm.models.Account;
import kg.megacom.atm.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findByClient(Client client);

    Account findByAccount(String account);
}
