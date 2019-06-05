package com.Dawid;

public class NumberLessThanZero extends RuntimeException  {


    ErrorDescription errorDescription;

    public NumberLessThanZero(ErrorDescription errorDescription){
        this.errorDescription=errorDescription;
    }

    public ErrorDescription getErrorDescription() {
        return errorDescription;
    }

}
