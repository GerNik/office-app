package ru.gernik.auth.utils

import org.testcontainers.containers.GenericContainer

class MongoContainer : GenericContainer<MongoContainer>("mongo")