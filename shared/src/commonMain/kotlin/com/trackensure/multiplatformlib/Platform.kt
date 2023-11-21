package com.trackensure.multiplatformlib

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform