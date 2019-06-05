package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CurrencyPair currencyPair;

    @Autowired
    private OperationLogger operationLogger;

    @Autowired
    private OperationReader operationReader;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/operation",method = RequestMethod.GET)
    public double operation(@RequestParam(value = "currency") String currency, @RequestParam(value = "amount") double amount )throws IOException {
        double result=currencyPair.result(currency,amount);
        OperationData operationData = new OperationData();
        operationData.setOperation(currency);
        operationData.setAmount(String.valueOf(amount));
        operationData.setResult(String.valueOf(result));
        operationLogger.log(operationData);
        return result ;
   }

    @RequestMapping("/operationData")
    public List<OperationData> getOperationList(){

        return operationReader.getOperationList();
    }

    @ExceptionHandler({NumberLessThanZero.class})
    public ErrorDescription returnException(NumberLessThanZero ex) {
        return ex.getErrorDescription();
    }

}