package ru.gernik.gateway.configiration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.DispatcherHandler

@Configuration
class GatewayConfiguration{

    @Bean
    fun dispatcherHandler() : DispatcherHandler{
        return DispatcherHandler()
    }
}