package main

enum class AntDirection(var stepX: Int, var stepY: Int) {
    RIGHT(1, 0),
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0)
}