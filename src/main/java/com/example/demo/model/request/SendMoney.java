package com.example.demo.model.request;

import javax.validation.constraints.NotNull;

public class SendMoney {
    @NotNull
    private String typeMoney;
    @NotNull
    private Double amount;

    public SendMoney(String typeMoney, Double amount) {
        this.typeMoney = typeMoney;
        this.amount = amount;
    }

    public String getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(String typeMoney) {
        this.typeMoney = typeMoney;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
