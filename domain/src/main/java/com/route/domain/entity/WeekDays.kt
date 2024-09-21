package com.route.domain.entity

enum class WeekDays(val fullWeekName: String) {
    SAT("Saturday"),
    SUN("Sunday"),
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday")
}

val sat = WeekDays.MON

// Loading ()
// Error   (message :String)
// Success (data : T)


sealed class ApiResult<T> {
    class Loading<T> : ApiResult<T>()
    data class Error<T>(val message: String) : ApiResult<T>()
    data class Success<T>(val data: T) : ApiResult<T>()
}









