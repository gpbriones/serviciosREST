package com.examen.demo.model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;

    private LocalDateTime dateCreated;

    private String Status;
    private String name;

    public Transaction() {
    }

    public Transaction(String transactionId, LocalDateTime dateCreated, String status, String name) {
        this.transactionId = transactionId;
        this.dateCreated = dateCreated;
        Status = status;
        this.name = name;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", Status=" + Status
                + ", name=" + name + "]";
    }

}
