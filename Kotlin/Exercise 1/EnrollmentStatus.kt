package Exercise_1

sealed class EnrollmentStatus {
    data class Success(val courseCode: String) : EnrollmentStatus()
    data class Error(val message: String) : EnrollmentStatus()
    data class Loading(val message: String) : EnrollmentStatus()
}

fun printStatus(status: EnrollmentStatus) {
    when (status) {
        is EnrollmentStatus.Success -> println("Success")
        is EnrollmentStatus.Loading -> println("Loading")
        is EnrollmentStatus.Error -> println("Error")
    }
}
fun main() {

    printStatus(EnrollmentStatus.Success("Enrolled"))
    printStatus(EnrollmentStatus.Error("Error"))
}