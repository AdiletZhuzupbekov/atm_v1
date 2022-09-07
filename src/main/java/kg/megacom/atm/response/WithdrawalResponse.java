package kg.megacom.atm.response;

import kg.megacom.atm.models.dto.NaminalDto;
import lombok.Data;

import java.util.HashSet;

@Data
public class WithdrawalResponse {
    private String account;
    private double amount;
    private double rest;
    private HashSet<NaminalDto> nominals;
}
