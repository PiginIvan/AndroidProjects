package com.example.lab3

import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun inc(number: Int): Int {
        return number + 1
    }
    fun dec(number: Int): Int {
        return number - 1
    }
    fun random(): Int {
        return Random.nextInt(-100, 100)
    }
}