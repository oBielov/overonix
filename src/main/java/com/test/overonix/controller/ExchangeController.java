package com.test.overonix.controller;

import com.test.overonix.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/currency-exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping(path = "/latest/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLatest(@PathVariable("code") String code){
        return new ResponseEntity<>(exchangeService.getLatest(code), HttpStatus.OK);
    }

    @GetMapping(path = "{base_code}/{target_code}/rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPair(
            @PathVariable("base_code") String baseCode,
            @PathVariable("target_code") String targetCode
    ){
        return new ResponseEntity<>(exchangeService.getPair(baseCode, targetCode), HttpStatus.OK);
    }

    @GetMapping(path = "{base_code}/{target_code}/{amount}/sum", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPairWithAmount(
            @PathVariable("base_code") String baseCode,
            @PathVariable("target_code") String targetCode,
            @PathVariable("amount") double amount
    ){
        return new ResponseEntity<>(exchangeService.getPair(baseCode, targetCode, amount), HttpStatus.OK);
    }

    @GetMapping(path = "/supported-codes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSupportedCodes(){
        return new ResponseEntity<>(exchangeService.getSupportedCodes(), HttpStatus.OK);
    }
}
