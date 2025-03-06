package com.example.lab3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform