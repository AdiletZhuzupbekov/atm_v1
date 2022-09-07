package kg.megacom.atm.request;

import lombok.Data;

@Data
public class WithdrawalRequest {
    private String account;
    private double amount;
}
