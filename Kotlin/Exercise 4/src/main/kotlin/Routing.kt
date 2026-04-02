package com.example

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.ByteArrayOutputStream


fun saveQRCode(content: String, fileName: String): ByteArrayOutputStream {
    val bitMatrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200)

    val outputStream = ByteArrayOutputStream()
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream)
    return outputStream
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/{email}/{fileName}") {
            val byteArray = saveQRCode(call.parameters["email"]!!, call.parameters["fileName"]!!)
            call.respond(byteArray.toByteArray())
            call.respondText { "Done!!!" }
        }
        get("/qr") {
            val data = call.request.queryParameters["text"] ?: return@get call.respondText { "data is missing" }

            val byteArray = saveQRCode(data, "")

            call.respond(byteArray.toByteArray())

        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
