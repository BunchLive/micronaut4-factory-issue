package com.example.config

import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter

/**
 * Configuration for use by SomeFactory.
 */
@EachProperty("example.beans")
class SomeBeanConfig(
    @param:Parameter
    val name: String,
)
