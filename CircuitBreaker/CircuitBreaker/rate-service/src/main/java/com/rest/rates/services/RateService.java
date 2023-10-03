package com.rest.rates.services;

import com.rest.rates.entities.Rate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateService {

    private ConcurrentHashMap<String,Rate> rateMap;

    public RateService(){
        rateMap = new ConcurrentHashMap<>();
    }


    public Rate getRateByType(String type) {
        return findByType(type);
    }

    private Rate findByType(String type){
        if(rateMap.containsKey(type)){
            return rateMap.get(type);
        }
        return null;
    }

    @PostConstruct
    public void setupData() {
        rateMap.put("PERSONAL",createRateObj(1,"PERSONAL",10.0));
        rateMap.put("HOUSING",createRateObj(2,"HOUSING",8.0));
    }

    private Rate createRateObj(Integer id, String type,Double rateValue){
        Rate rateObj = new Rate();
        rateObj.setId(id);
        rateObj.setType(type);
        rateObj.setRateValue(rateValue);
        return rateObj;
    }
}
