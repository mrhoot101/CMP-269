package com.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

data class Stock(val symbol: String, val price: Double){
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {

        json()
    }
    routing {
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
        get("/ap1/stock/{symbol}") {
            val stockObject = Stock(call.parameters["symbol"].toString(), 150.25)
            call.respond(Json.encodeToString(stockObject))
        }
    }
}
