package com.Dawid;

public class ErrorDescription {

        double value;
        String message;

        public ErrorDescription(double value, String message) {
            this.value = value;
            this.message = message;
        }

        public double getValue() {
            return value;
        }

        public String getMessage() {
            return message;
        }
    }

