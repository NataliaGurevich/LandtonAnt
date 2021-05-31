package main

enum class AntDirection(var stepX: Int, var stepY: Int) {
    RIGHT(1, 0),
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0);

    fun changeDirectionIfWhiteColor(): AntDirection{
        return when (this) {
            UP -> RIGHT
            DOWN -> LEFT
            RIGHT -> DOWN
            LEFT -> UP
        }
    }

    fun changeDirectionIfBlackColor(): AntDirection{
        return when (this) {
            UP -> LEFT
            DOWN -> RIGHT
            RIGHT -> UP
            LEFT -> DOWN
        }
    }
}