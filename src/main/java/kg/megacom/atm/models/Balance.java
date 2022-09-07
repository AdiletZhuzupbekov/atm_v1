package kg.megacom.atm.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "balances")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
}
