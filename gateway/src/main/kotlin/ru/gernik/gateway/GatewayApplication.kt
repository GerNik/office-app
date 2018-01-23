package ru.gernik.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
open class GatewayApplication

fun main(args: Array<String>) {
    SpringApplication.run(GatewayApplication::class.java, *args)
}