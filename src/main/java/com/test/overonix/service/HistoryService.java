package com.test.overonix.service;

import com.test.overonix.repository.CurrencyRepository;
import com.test.overonix.model.CurrencyHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private CurrencyRepository repository;

    public List<CurrencyHistory> getAll(){
        return repository.findAll();
    }

    public void createHistory(){

    }
}
