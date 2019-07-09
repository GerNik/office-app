package ru.gernik.gateway.configiration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.support.DefaultServerCodecConfigurer

@Configuration
class GatewayConfiguration {

    @Bean
    fun serverCodecConfigurer(): ServerCodecConfigurer {
        return DefaultServerCodecConfigurer()
    }
}