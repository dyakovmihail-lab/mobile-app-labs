package com.example.lab01.data

import kotlin.random.Random

class NumberGenerator {

    fun generate(size: Int): List<Int> {

        return List(size) {
            Random.nextInt(0, 10)
        }

    }

}