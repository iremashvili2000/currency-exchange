package com.example.demo.controller;

import com.example.demo.model.request.ExchangeMoney;
import com.example.demo.model.request.SendMoney;
import com.example.demo.model.response.Exchange;
import com.example.demo.service.OpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class OpenController {

       private final OpenService openService;

    public OpenController(OpenService openService) {
        this.openService = openService;
    }

    @RequestMapping(value = "/exchange/list",method = RequestMethod.GET)
    public List<Exchange> getExchangeList() throws IOException {
         return    openService.getExchangeList();
    }
    @RequestMapping(value = "/currency/exchange",method = RequestMethod.GET)
    public Double getExchangeMoney(@Valid @RequestBody SendMoney sendMoney){
       return openService.currencyExchange(sendMoney);
    }
    @RequestMapping(value = "/lari/exchange",method = RequestMethod.GET)
    public Double getlariExchange(@Valid @RequestBody SendMoney sendMoney){
        return openService.lariExchange(sendMoney);
    }

    @RequestMapping(value = "/exchange",method = RequestMethod.GET)
    public Double exchange(@Valid @RequestBody ExchangeMoney exchangeMoney){
        return openService.exchange(exchangeMoney);
    }

}
