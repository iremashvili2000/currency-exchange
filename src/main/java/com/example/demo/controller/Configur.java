package com.example.demo.controller;

import com.example.demo.model.response.Exchange;
import com.example.demo.repository.ExchangeRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@EnableScheduling
public class Configur {
    private final ExchangeRepository exchangeRepository;

    public Configur(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Scheduled(fixedDelay = 1000*60*60*24,initialDelay = 1000*60*10)
    public void saveExchanges() throws IOException {
        getExchangeList(getExchangeRequests());
    }

    private void getExchangeList(String link) {
        Gson gson=new Gson();
        System.out.println(link);
        List<Exchange> exchanges=gson.fromJson(link.toString(),new TypeToken<List<Exchange>>(){}.getType());
        exchangeRepository.saveAll(exchanges);
    }



    private String getExchangeRequests() throws IOException {
        OkHttpClient client=new OkHttpClient();
        String linki="https://any.ge/currency/api.php?ids=1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25";
        Request request=new Request.Builder()
                .url(linki).build();
        Call call=client.newCall(request);
        Response response=call.execute();
        byte[] bytes=response.body().string().getBytes(StandardCharsets.UTF_8);
        String send=new String(bytes,StandardCharsets.UTF_8);
        return send;
    }


}
