package main

import java.awt.Point

class Ant(var pointCurrent: Point = Point(0, 0),
          var directionCurrent: AntDirection = AntDirection.LEFT,
          var fields: MutableMap<Point, FieldColor> = mutableMapOf(pointCurrent to FieldColor.WHITE),
          private var stepCounter: Int = 0) {

    fun step() {
        stepCounter++
        directionCurrent = directionNext()
        changeFieldColor(pointCurrent)
        println(this)
        pointCurrent = pointNext()
    }

    private fun pointNext() = Point(pointCurrent.x + directionCurrent.stepX, pointCurrent.y + directionCurrent.stepY)

    private fun changeFieldColor(point: Point) {
        val newColor = fields[point] ?: FieldColor.WHITE
        fields[point] = newColor.changeColor()
    }

    private fun directionNext(): AntDirection {
        val fieldColor = fields[pointCurrent] ?: FieldColor.WHITE
        return when (directionCurrent) {
            AntDirection.UP ->
                if (fieldColor == FieldColor.WHITE) AntDirection.RIGHT else AntDirection.LEFT
            AntDirection.DOWN ->
                if (fieldColor == FieldColor.WHITE) AntDirection.LEFT else AntDirection.RIGHT
            AntDirection.RIGHT ->
                if (fieldColor == FieldColor.WHITE) AntDirection.DOWN else AntDirection.UP
            AntDirection.LEFT ->
                if (fieldColor == FieldColor.WHITE) AntDirection.UP else AntDirection.DOWN
        }
    }

    override fun toString(): String {
        return "step: $stepCounter [point.x=${pointCurrent.x} ; point.y=${pointCurrent.y}] color=${fields[pointCurrent] ?: FieldColor.WHITE} direction=$directionCurrent directionNext=${directionNext()}"
    }

    //for assertions in tests
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ant

        if (pointCurrent != other.pointCurrent) return false
        if (directionCurrent != other.directionCurrent) return false
        if (fields != other.fields) return false
        if (stepCounter != other.stepCounter) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pointCurrent.hashCode()
        result = 31 * result + directionCurrent.hashCode()
        result = 31 * result + fields.hashCode()
        result = 31 * result + stepCounter
        return result
    }
}