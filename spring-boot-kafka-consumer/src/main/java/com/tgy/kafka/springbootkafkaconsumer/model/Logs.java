package com.tgy.kafka.springbootkafkaconsumer.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Logs {


    private String city;
    private String message;
    private String type;
    private String date;

    public Logs(String city, String message, String type, String date) {
        this.city = city;
        this.message = message;
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Log{" +
                "city='" + city + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
