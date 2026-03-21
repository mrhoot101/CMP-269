
data class WebResponse(val statusCode: Int, val statusMessage: String, val body: String?) {
}

fun describeStatus(code: Int): String {
    when (code) {
        in 200..299 -> return "Success: The request was fulfilled."
        in 400..499 -> return "Client Error: Check your URL or parameters."
        in 500..599 -> return "Sever Error: The Lehman Server is having trouble."
        else -> return "Unknown status code."
    }
}

fun routeRequest(path: String, user: String?) : String{
    when (path) {
        "/home" -> return "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"
        "/grades" -> if (user == null) return "Error: Unauthorized access to grades." else return "Loading grades for $user..."
        else -> return "404: Path $path not found."
    }
}

fun main(){
    // Exercise 1
    val responseSuccess = WebResponse(200, "Success", null)
    val responseError = WebResponse(404, "Not Found", null)
    println(responseSuccess)
    println(responseError)

    println()

    // Exercise 2
    println(describeStatus(201))
    println(describeStatus(404))
    println(describeStatus(503))
    println(describeStatus(2))

    println()

    // Exercise 3
    println(routeRequest("/home", "Moises"))
    println(routeRequest("/grades", null))
    println(routeRequest("/grades", "Moises"))
    println(routeRequest("/whatever", "Moises"))
}
