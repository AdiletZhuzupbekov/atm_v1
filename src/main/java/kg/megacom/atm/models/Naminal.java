package kg.megacom.atm.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "naminals")
public class Naminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double naminal;
    private double amount;
}
