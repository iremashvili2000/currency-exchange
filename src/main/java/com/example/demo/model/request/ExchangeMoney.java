package com.example.demo.model.request;

public class ExchangeMoney {

    private String yourmoneytype;

    private Double amount;

    private  String moneytype;


    public ExchangeMoney(String yourmoneytype, Double amount, String moneytype) {
        this.yourmoneytype = yourmoneytype;
        this.amount = amount;
        this.moneytype = moneytype;
    }

    public String getYourmoneytype() {
        return yourmoneytype;
    }

    public void setYourmoneytype(String yourmoneytype) {
        this.yourmoneytype = yourmoneytype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMoneytype() {
        return moneytype;
    }

    public void setMoneytype(String moneytype) {
        this.moneytype = moneytype;
    }
}
