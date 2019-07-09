package ru.gernik.route

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OfficeApplication

fun main(args: Array<String>) {
    runApplication<OfficeApplication>(*args)
}