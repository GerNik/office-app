package ru.gernik.auth.configuration

import com.google.common.collect.Lists.newArrayList
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import springfox.documentation.schema.ModelRef
import springfox.documentation.builders.ResponseMessageBuilder
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.Collections.singletonList


@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Value("\${swagger.context.root}")
    private val contextRoot: String? = null
    @Value("\${spring.application.name}")
    private val appName: String? = null
    @Value("\${spring.application.description}")
    private val appDescription: String? = null

    @Bean
    fun apiInfo(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfoBuilder()
                        .title(appName)
                        .description(appDescription)
                        .build())
                .useDefaultResponseMessages(false)
                .pathMapping(contextRoot)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                .build()
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(ModelRef("Error"))
                                .build()))
                .produces(HashSet(singletonList(APPLICATION_JSON_VALUE)))
                .consumes(HashSet(singletonList(APPLICATION_JSON_VALUE)))
    }
}