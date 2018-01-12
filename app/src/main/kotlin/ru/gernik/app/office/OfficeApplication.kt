package ru.gernik.app.office

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class OfficeApplication

fun main(args: Array<String>) {
    SpringApplication.run(OfficeApplication::class.java, *args)
}