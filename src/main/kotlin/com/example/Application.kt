package com.example

import io.micronaut.runtime.Micronaut.run
import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
	build(*args)
		.banner(false)
		.start()
}

