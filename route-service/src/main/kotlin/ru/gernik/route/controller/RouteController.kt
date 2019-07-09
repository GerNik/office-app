package ru.gernik.route.controller

import org.springframework.web.bind.annotation.*

@RequestMapping("/routes")
@RestController
class RouteController () {

    @GetMapping
    fun getRoutes() : String {
        return "routes"
    }
}