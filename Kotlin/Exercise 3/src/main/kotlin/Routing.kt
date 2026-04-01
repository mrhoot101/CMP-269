package com.example

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondText("Server is online at Lehman College.")
        }
        get("/greet/{name}") {
            val name: String = call.parameters["name"]!!
            call.respondText("Hello, $name! Welcome to CMP 269.")
        }
        get("/grade/{studentId?}") {
            val grade = mapOf("123" to 95, "456" to 82)

            if (call.parameters["studentId"].equals("123") || call.parameters["studentId"].equals("456")) {
                call.respondText(grade.get(call.parameters["studentID"]).toString())
            }
            else {
                call.respondText("Student not found", ContentType.Text.Plain,HttpStatusCode.NotFound)
            }
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
