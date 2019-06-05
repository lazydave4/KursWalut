package com.Dawid;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
class CurrencyPair {

    public double result(String nameCurrency, double amount) throws IOException {

        if (amount < 0) {
            ErrorDescription newError = new ErrorDescription(amount, "number less than zero");
            throw new NumberLessThanZero(newError);
        }
        return amount*returnCourseInNBP(nameCurrency);
    }
    public double returnCourseInNBP(String currency) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String adresUrl = "http://api.nbp.pl/api/exchangerates/rates/A/"+currency+"?format=json";
        String score = restTemplate
                .getForObject(adresUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(score);
        return root.findPath("mid").asDouble();

    }
    }
