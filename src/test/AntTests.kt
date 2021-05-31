package test

import main.Ant
import main.AntDirection
import main.FieldColor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.awt.Point

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AntTests {

    @Test
    fun checkStartPosition() {
        val antStartExpected = Ant(pointCurrent = Point(0, 0),
                directionCurrent = AntDirection.LEFT,
                mutableMapOf(Point(0, 0) to FieldColor.WHITE),
                stepCounter = 0)
        val antActual = Ant()
        assertEquals(antStartExpected, antActual)
    }

    @Test
    fun checkFirstStep() {
        val antFirstStepExpected = Ant(pointCurrent = Point(0, 1),
                directionCurrent = AntDirection.UP,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK),
                stepCounter = 1)
        val antActual = Ant()
        antActual.step()
        assertEquals(antFirstStepExpected, antActual)
    }

    @Test
    fun checkSecondStep() {
        val step = 2
        val antSecondStepExpected = Ant(pointCurrent = Point(1, 1),
                directionCurrent = AntDirection.RIGHT,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antSecondStepExpected, antActual)
    }

    @Test
    fun checkThirdStep() {
        val step = 3
        val antThirdStepExpected = Ant(pointCurrent = Point(1, 0),
                directionCurrent = AntDirection.DOWN,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antThirdStepExpected, antActual)
    }

    @Test
    fun checkForthStep() {
        val step = 4
        val antForthStepExpected = Ant(pointCurrent = Point(0, 0),
                directionCurrent = AntDirection.LEFT,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antForthStepExpected, antActual)
    }

    @Test
    fun checkFifthStep() {
        val step = 5
        val antFifthStepExpected = Ant(pointCurrent = Point(0, -1),
                directionCurrent = AntDirection.DOWN,
                mutableMapOf(Point(0, 0) to FieldColor.WHITE,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antFifthStepExpected, antActual)
    }

    @Test
    fun checkSixthStep() {
        val step = 6
        val antSixthStepExpected = Ant(pointCurrent = Point(-1, -1),
                directionCurrent = AntDirection.LEFT,
                mutableMapOf(Point(0, 0) to FieldColor.WHITE,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.BLACK),
                stepCounter = step)
        val rangeStep = 1..step
        val antActual = Ant()
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antSixthStepExpected, antActual)
    }

    @Test
    fun checkSeventhStep() {
        val step = 7
        val antSeventhStepExpected = Ant(pointCurrent = Point(-1, 0),
                directionCurrent = AntDirection.UP,
                mutableMapOf(Point(0, 0) to FieldColor.WHITE,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.BLACK,
                        Point(-1, -1) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antSeventhStepExpected, antActual)
    }

    @Test
    fun checkEighthStep() {
        val step = 8
        val antEighthStepExpected = Ant(pointCurrent = Point(0, 0),
                directionCurrent = AntDirection.RIGHT,
                mutableMapOf(Point(0, 0) to FieldColor.WHITE,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.BLACK,
                        Point(-1, -1) to FieldColor.BLACK,
                        Point(-1, 0) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antEighthStepExpected, antActual)
    }

    @Test
    fun checkNinthStep() {
        val step = 9
        val antNinthStepExpected = Ant(pointCurrent = Point(0, -1),
                directionCurrent = AntDirection.DOWN,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.BLACK,
                        Point(-1, -1) to FieldColor.BLACK,
                        Point(-1, 0) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antNinthStepExpected, antActual)
    }

    @Test
    fun checkTenthStep() {
        val step = 10
        val antTenthStepExpected = Ant(pointCurrent = Point(1, -1),
                directionCurrent = AntDirection.RIGHT,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.WHITE,
                        Point(-1, -1) to FieldColor.BLACK,
                        Point(-1, 0) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antTenthStepExpected, antActual)
    }

    @Test
    fun checkEleventhStep() {
        val step = 11
        val antEleventhStepExpected = Ant(pointCurrent = Point(1, -2),
                directionCurrent = AntDirection.DOWN,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.WHITE,
                        Point(-1, -1) to FieldColor.BLACK,
                        Point(-1, 0) to FieldColor.BLACK,
                        Point(1, -1) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antEleventhStepExpected, antActual)
    }

    @Test
    fun checkTwelfthStep() {
        val step = 12
        val antTwelfthStepExpected = Ant(pointCurrent = Point(0, -2),
                directionCurrent = AntDirection.LEFT,
                mutableMapOf(Point(0, 0) to FieldColor.BLACK,
                        Point(0, 1) to FieldColor.BLACK,
                        Point(1, 1) to FieldColor.BLACK,
                        Point(1, 0) to FieldColor.BLACK,
                        Point(0, -1) to FieldColor.WHITE,
                        Point(-1, -1) to FieldColor.BLACK,
                        Point(-1, 0) to FieldColor.BLACK,
                        Point(1, -1) to FieldColor.BLACK,
                        Point(1, -2) to FieldColor.BLACK),
                stepCounter = step)
        val antActual = Ant()
        val rangeStep = 1..step
        for (i in rangeStep) {
            antActual.step()
        }
        assertEquals(antTwelfthStepExpected, antActual)
    }
}
