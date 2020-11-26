package com.mariposa.demo.stockclient;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.io.IOException;

// Created by: Logan Kells
// Date: 11/26/2020
// Reference: This WebClientStockClient class was created using the tutorial https://blog.jetbrains.com/idea/2019/11/tutorial-reactive-spring-boot-a-rest-client-for-reactive-streams/

/** Java class WebClientStockClient, this is going to use Spring’s WebClient to connect to the stock prices service.*/
@Log4j2
public class WebClientStockClient {
    private WebClient webClient;

    // Class constructor
    public WebClientStockClient(WebClient webClient){
        this.webClient = webClient;
    }

    public Flux<StockPrice> pricesFor(String symbol) {
        // Connect to the real webclient service
        return webClient.get()
                        .uri("http://localhost:8080/stocks/{symbol}", symbol)
                        .retrieve()
                        .bodyToFlux(StockPrice.class)
                        .retry(5)
                        .doOnError(IOException.class, e -> log.error(e.getMessage()));
        //return Flux.fromArray(new StockPrice[0]);
    }
}
