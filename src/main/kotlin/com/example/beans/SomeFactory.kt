package com.example.beans

import com.example.config.SomeBeanConfig
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.EachBean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Parameter

@Factory
class SomeFactory {
    // This is the broken version of the factory method.
    // It will fail with the following error:
    //
    // "No bean of type [com.example.beans.SomeBean] exists for the given qualifier: @Named('bar')."
    @Context
    @EachBean(SomeBeanConfig::class)
    fun brokenCreateSomeBean(@Parameter name: String): SomeBean {
        return SomeBean(name)
    }

    // Below is a version of the factory method which provides a workaround.
    // SomeBean's EachProperty annotation is somehow interfering with the factory method.

//    @Context
//    @EachBean(SomeBeanConfig::class)
//    fun workingCreateSomeBean(@Parameter name: String): WrappedSomeBean {
//        return WrappedSomeBean(name)
//    }
}
