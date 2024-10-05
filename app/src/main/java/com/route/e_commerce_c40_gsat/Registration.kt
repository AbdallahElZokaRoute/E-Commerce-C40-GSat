package com.route.e_commerce_c40_gsat

import java.util.regex.Matcher
import java.util.regex.Pattern


class Registration {
    // Email address is Valid
    // Username not Empty and should be length > 2
    // Password should 6 chars or digits at least
    // TDD (Test Drivin Development)

    fun register(email: String, username: String, password: String): Boolean {
        var isValid = true
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val matcher: Matcher = pattern.matcher(email)
        val matchFound = matcher.matches()
        if (email.isEmpty() || !matchFound)
            return false
        if (username.isEmpty())
            return false
        if (password.isEmpty() || password.length < 6)
            return false
        return true
    }
}

