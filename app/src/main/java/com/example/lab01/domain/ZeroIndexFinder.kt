package com.example.lab01.domain

class ZeroIndexFinder {

    fun findZeroIndexes(numbers: List<Int>): List<Int> {
        return numbers.mapIndexedNotNull { index, value ->
            if (value == 0) index else null
        }
    }
}