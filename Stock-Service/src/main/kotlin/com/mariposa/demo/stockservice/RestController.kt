package com.mariposa.demo.stockservice

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.concurrent.ThreadLocalRandom
// Created by: Logan Kells
// Date: 11/26/2020
// Reference: This RestController was created following the tutorial https://blog.jetbrains.com/idea/2019/10/tutorial-reactive-spring-boot-a-kotlin-rest-service/

@RestController
class RestController{
    @GetMapping(value = ["/stocks/{symbol}"],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(@PathVariable symbol: String): Flux<StockPrice> {
        // Note: See Flux<T> here https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html
        return Flux
                .interval(Duration.ofSeconds(1))
                .map{StockPrice(symbol, randomStockPrice(), java.time.LocalDateTime.now())}
    }
    private fun randomStockPrice(): Double{
        // Generate a random stock price.
        return ThreadLocalRandom.current().nextDouble(100.0)
    }
}