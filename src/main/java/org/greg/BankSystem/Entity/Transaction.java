package org.greg.BankSystem.Entity;

import org.greg.BankSystem.Enums.TransactionType;

import java.util.Date;
import java.util.List;

public class Transaction {
    private double value;
    private TransactionType type;
    private Date timestamp;

    public Transaction(double value, TransactionType type, Date timestamp) {
        this.value = value;
        this.type = type;
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
