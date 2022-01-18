package com.test.overonix.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class ExchangeService {

    @Value("${exchange_resourceA}")
    private String address;

    public String getLatest(String code){
        String path = address + "/latest/" + code.toUpperCase();
        log.info(path);
        return responseBody(path);
    }

    public String getPair(String baseCode, String targetCode){
        String path = address + "/pair/" + baseCode.toUpperCase() + "/" + targetCode.toUpperCase();
        log.info(path);
        return responseBody(path);
    }

    public String getPair(String baseCode, String targetCode, double amount){
        String path = address + "/pair/"
                + baseCode.toUpperCase()
                + "/"
                + targetCode.toUpperCase()
                + "/"
                + amount;
        log.info(path);
        return responseBody(path);
    }

    public String getSupportedCodes(){
        String path = address + "/codes";
        log.info(path);
        return responseBody(path);
    }

    @SneakyThrows
    private String responseBody(String path){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
