package com.example.demo.service;

import com.example.demo.exception.BadDataException;
import com.example.demo.model.request.ExchangeMoney;
import com.example.demo.model.request.SendMoney;
import com.example.demo.model.response.Exchange;
import com.example.demo.repository.ExchangeRepository;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class OpenServiceImpl implements OpenService{
    private final ExchangeRepository exchangeRepository;
    public OpenServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public List<Exchange> getExchangeList() {
      return exchangeRepository.findAll();
    }

    @Override
    public Double currencyExchange(SendMoney sendMoney) {
      Optional<Exchange> exchange= exchangeRepository
              .getCurrencyCode(sendMoney.getTypeMoney());
      if(exchange.isEmpty()){
          throw new BadDataException("we work add this currency");
      }


      Double index=Double.parseDouble(exchange.get().getCur_value());
      Double money=sendMoney.getAmount()*index;
      return money;
    }

    @Override
    public Double lariExchange(SendMoney sendMoney) {
        Optional<Exchange> exchange= exchangeRepository
                .getCurrencyCode(sendMoney.getTypeMoney());
        if(exchange.isEmpty()){
            throw new BadDataException("we work add this currency if this is true");
        }

        Double index=Double.parseDouble(exchange.get().getCur_value());
        Double money=sendMoney.getAmount()/index;
        return money;
    }

    @Override
    public Double exchange(ExchangeMoney exchangeMoney) {
        Optional<Exchange> exchange1=exchangeRepository.getCurrencyCode(exchangeMoney.getYourmoneytype());
        if(exchange1.isEmpty()){
            throw new BadDataException("we work add this currency if this is true");
        }
        Optional<Exchange> exchange2=exchangeRepository.getCurrencyCode(exchangeMoney.getMoneytype());
        if(exchange2.isEmpty()){
            throw new BadDataException("we work add this currency if this is true");
        }

        Double index=Double.parseDouble(exchange1.get().getCur_value());
        Double money=exchangeMoney.getAmount()/index;
        Double index1=Double.parseDouble(exchange2.get().getCur_value());
        Double realmoney=index1*money;
        return realmoney;


    }


}
