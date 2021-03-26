package com.example.demo.service;

import com.example.demo.model.request.ExchangeMoney;
import com.example.demo.model.request.SendMoney;
import com.example.demo.model.response.Exchange;

import java.io.IOException;
import java.util.List;

public interface OpenService {
     List<Exchange> getExchangeList();

     Double currencyExchange(SendMoney sendMoney);

     Double lariExchange(SendMoney sendMoney);

     Double exchange(ExchangeMoney exchangeMoney);
}
