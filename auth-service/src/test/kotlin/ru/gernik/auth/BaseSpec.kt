package ru.gernik.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.containers.wait.Wait
import ru.gernik.auth.utils.MongoContainer

@SpringBootTest(
        properties = ["spring.cloud.discovery.enabled=false"],
        webEnvironment = RANDOM_PORT
)
class BaseSpec {

    @Autowired
    lateinit var context: WebApplicationContext

    lateinit var mockMvc: MockMvc

    inner class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            val mongo = MongoContainer()
                    .waitingFor(Wait.defaultWaitStrategy())
                    .withExposedPorts(27017)
            mongo.start()

            TestPropertyValues.of("spring.data.mongodb.host=" + mongo.containerIpAddress + ":" + mongo.getMappedPort(27017),
                    "spring.data.mongodb.database=investments").applyTo(applicationContext)
        }
    }

    fun setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build()
    }
}