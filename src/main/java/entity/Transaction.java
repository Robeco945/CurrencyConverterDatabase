package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    private LocalDateTime timestamp;

    public Transaction() {}

    public Transaction(double amount, Currency sourceCurrency, Currency targetCurrency) {
        this.amount = amount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.timestamp = LocalDateTime.now();
    }

    // getters and setters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Currency getSourceCurrency() { return sourceCurrency; }
    public Currency getTargetCurrency() { return targetCurrency; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setSourceCurrency(Currency sourceCurrency) { this.sourceCurrency = sourceCurrency; }
    public void setTargetCurrency(Currency targetCurrency) { this.targetCurrency = targetCurrency; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
