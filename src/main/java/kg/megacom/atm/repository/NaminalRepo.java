package kg.megacom.atm.repository;

import kg.megacom.atm.models.Naminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaminalRepo extends JpaRepository<Naminal, Long> {
}
