package com.route.e_commerce_c40_gsat

import org.junit.Assert.*
import org.junit.Test

class RegistrationTest {
    //            3
    //   optional
    //     Target Unit          -        Context  -           Expectation
    @Test
    fun `register() with valid Data then returns true`() {
        // Triple -A  Rule
        // Arrange
        val registerObject = Registration()
        val username = "ahmed"
        val password = "123456"
        val email = "ahmed@route.com"
        // Act
        val isValid = registerObject.register(email, username, password)
        // Assert
        assertTrue(isValid)
    }

    @Test
    fun `register() with short Password and other valid Data then returns false`() {
        // Arrange
        val registerObject = Registration()
        val username = "ahmed"
        val password = "12"
        val email = "ahmed@route.com"
        // Act
        val isValid = registerObject.register(email, username, password)
        // Assert
        assertFalse(isValid)
    }

    @Test
    fun `register() with email address in wrong format and other valid Data then returns false`() {
        // Arrange
        val registerObject = Registration()
        val username = "ahmed"
        val password = "123456"
        val email = "ahmedroute.com"
        // Act
        val isValid = registerObject.register(email, username, password)
        // Assert
        assertFalse(isValid)
    }


}