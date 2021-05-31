package main

enum class AntDirection(var stepX: Int, var stepY: Int) {
    RIGHT(1, 0),
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0);

    fun nextDirection(color: FieldColor): AntDirection {
        return if (color == FieldColor.WHITE) {
            when (this) {
                UP -> RIGHT
                DOWN -> LEFT
                RIGHT -> DOWN
                LEFT -> UP
            }
        } else {
            when (this) {
                UP -> LEFT
                DOWN -> RIGHT
                RIGHT -> UP
                LEFT -> DOWN
            }
        }
    }
}