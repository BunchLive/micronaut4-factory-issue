package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    /**
     * Test that the application is injected correctly and starts successfully.
     *
     * This test will fail with the following error:
     * "No bean of type [com.example.beans.SomeBean] exists for the given qualifier: @Named('bar')."
     */
    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }
}
