package com.mariposa.demo.stockclient;

// Created by: Logan Kells
// Date: 11/26/2020
// Reference: This lombok.Data class was created using the tutorial https://blog.jetbrains.com/idea/2019/11/tutorial-reactive-spring-boot-a-rest-client-for-reactive-streams/

@lombok.Data // Data using lombok.Data
@lombok.AllArgsConstructor // via lombok.AllArgsConstructor
@lombok.NoArgsConstructor // via lombok.NoArgsConstructor
public class StockPrice {
    private String symbol;
    private Double price;
    private java.time.LocalDate time;
}
