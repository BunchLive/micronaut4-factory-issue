package com.example

import com.example.beans.SomeBean
import io.micronaut.context.annotation.Context
import jakarta.inject.Named

/**
 * This class is just to define an injection point for SomeBean to force the bean's creation.
 */
@Context
class ServiceThing(@Named("bar") val bean: SomeBean) {
    /**
     * Do something.
     */
    fun doThing(): String {
        return "ServiceThing: ${bean.doThing()}"
    }
}
