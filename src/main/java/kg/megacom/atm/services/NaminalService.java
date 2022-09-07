package kg.megacom.atm.services;

import kg.megacom.atm.models.Naminal;

import java.util.HashSet;
import java.util.List;

public interface NaminalService {
    List<Naminal> withdrawCash(double amount);
}
