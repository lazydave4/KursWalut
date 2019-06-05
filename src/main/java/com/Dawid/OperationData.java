package com.Dawid;

public class OperationData {

    private  String amount;
    private String operation;
    private String result;
    public OperationData(){

    }
    public OperationData( String operation,String amount,String result) {
        this.operation = operation;
        this.amount = amount;
        this.result=result;
    }

    public OperationData(String operation, String amount) {
        this.amount = amount;
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount =amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
