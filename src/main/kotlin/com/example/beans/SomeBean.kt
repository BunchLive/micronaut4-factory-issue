package com.example.beans

import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter

/**
 * Example bean, which is used to demonstrate the problem.
 * This bean has an @EachProperty annotation which is not used in the test.
 * There is instead a Factory class which uses @EachBean and some separate configuration to create this bean.
 * Since Micronaut 4.x, the factory fails to create this bean without "wrapping" it in a subclass.
 */
@EachProperty("some.property.that.does.not.exist", primary = "default")
open class SomeBean(@param:Parameter val name: String) {
    /**
     * Do something.
     */
    fun doThing(): String {
        return name
    }
}
