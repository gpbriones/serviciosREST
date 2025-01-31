package com.examen.demo.model.request;

import java.io.Serializable;

public class TransactionRequest implements Serializable {

    private Long id;
    private String name;
    private String status;

    public TransactionRequest() {
    }

    public TransactionRequest(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionRequest [id=" + id + ", name=" + name + ", status=" + status + "]";
    }

}
