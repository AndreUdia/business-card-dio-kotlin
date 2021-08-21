package com.cabomaldade.businescarddio.utils

import kotlin.random.Random

// Extracted from https://stackoverflow.com/questions/35459454/java-random-color-string

fun retrieveRandomColorInHexadecimal() : String {
    val colorInInteger: Int = Random.nextInt(0xffffff + 1)
    return String.format("#%06x", colorInInteger)
}
