package com.mariposa.demo.stockservice

// Created by: Logan Kells
// Date: 11/26/2020
// Reference: This data class StockPrice was created using the tutorial https://blog.jetbrains.com/idea/2019/10/tutorial-reactive-spring-boot-a-kotlin-rest-service/

// NOTE: This is a Kotlin data class: https://kotlinlang.org/docs/reference/data-classes.html#data-classes
data class StockPrice(val symbol: String,
                      val price: Double,
                      val time: java.time.LocalDateTime)
