package com.tgy.kafka.springbootkafkaproducer.model;

public class Logs {
    private String logTime;
    private String type;
    private String city;
    private String message;

    public Logs(String logTime, String type, String city, String message) {
        this.logTime = logTime;
        this.type = type;
        this.city = city;
        this.message = message;
    }

    public Logs() {
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
