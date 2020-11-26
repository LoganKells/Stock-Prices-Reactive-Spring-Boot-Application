package com.mariposa.demo.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

// Created by: Logan Kells
// Date: 11/26/2020
// Reference: This junit.apa.Test was created using the tutorial https://blog.jetbrains.com/idea/2019/11/tutorial-reactive-spring-boot-a-rest-client-for-reactive-streams/

class WebClientStockClientIntegrationTest {
    private WebClient webClient = WebClient.builder().build();
    @Test
    void shouldRetrieveStockPricesFromTheService(){
        // Given...
        WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);

        // When...
        Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");

        // Then...
        // NOTE - We're only assessing the happy path (https://en.wikipedia.org/wiki/Happy_path) in this Junit test.
        // Define test expectations. We assume that if the service is working, then the prices should != null
        Assertions.assertNotNull(prices);
        // We'd also to think if we take five prices from the flux, we have more than one price
        Flux<StockPrice> fivePrices = prices.take(5);
        Assertions.assertEquals(5, fivePrices.count().block());
        Assertions.assertEquals("SYMBOL", fivePrices.blockFirst().getSymbol());
    }

}