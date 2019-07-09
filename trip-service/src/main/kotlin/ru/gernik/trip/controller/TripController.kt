package ru.gernik.trip.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/trips")
@RestController
class TripController {

    @GetMapping
    fun getTrips() : String {
        return "trips"
    }
}