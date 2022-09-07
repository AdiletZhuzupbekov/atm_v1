package kg.megacom.atm.services.impl;

import kg.megacom.atm.models.Naminal;
import kg.megacom.atm.repository.NaminalRepo;
import kg.megacom.atm.services.NaminalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NaminalServiceImpl implements NaminalService {
    private final NaminalRepo naminalRepo;

    public NaminalServiceImpl(NaminalRepo naminalRepo) {
        this.naminalRepo = naminalRepo;
    }

    @Override
    public List<Naminal> withdrawCash(double amount) {
        List<Naminal> naminals = new ArrayList<>();


        for (long i = 1; i <= 8;i++){
            Naminal naminal = naminalRepo.findById(i).orElseThrow();
            Naminal nam = new Naminal();
            for (int j = 0; j < amount; j++){
                if (naminal.getNaminal() > 0 && naminal.getNaminal() <= amount) {
                    naminal.setAmount(naminal.getAmount() - 1);
                    nam.setNaminal(naminal.getNaminal());
                    nam.setAmount(nam.getAmount()+1);
                    amount -= naminal.getNaminal();
                    naminals.add(nam);
                    naminalRepo.save(naminal);
                }
            }

        }
        return naminals;
    }
}
