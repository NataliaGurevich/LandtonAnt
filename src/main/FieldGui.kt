package main

import java.awt.Color
import java.awt.Graphics
import java.awt.Image
import java.awt.Point
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel
import javax.swing.Timer

class FieldGui : JPanel(), ActionListener {
    private val sizeFieldX: Int = 1280 * 2
    private val sizeFieldY: Int = 800 * 2
    private val sizeCell: Int = 8

    private val antUp: Image = ImageIO.read(File("src/main/images/up_8.png"))
    private val antDown: Image = ImageIO.read(File("src/main/images/down_8.png"))
    private val antRight: Image = ImageIO.read(File("src/main/images/right_8.png"))
    private val antLeft: Image = ImageIO.read(File("src/main/images/left_8.png"))
    private val blackCell: Image = ImageIO.read(File("src/main/images/blackCell_8.png"))
    private val whiteCell: Image = ImageIO.read(File("src/main/images/whiteCell_8.png"))

    private var positionStepX: Int = sizeCell * 50
    private var positionStepY: Int = sizeCell * 30
    var delayCurrent = 550
        set(value) {
            field = value
            this.timer.delay = value
        }

    private var mapCells: MutableMap<Point, Image>? = null
    private var mapDirection: MutableMap<Point, Image>? = null

    private var ant: Ant = Ant()

    private lateinit var timer: Timer

    init {
        background = Color.LIGHT_GRAY
        repaint()
    }

    fun startGame() {
        mapCells = mutableMapOf(Point(positionStepX, positionStepY) to whiteCell)
        mapDirection = mutableMapOf(Point(positionStepX, positionStepY) to antLeft)
        timer = Timer(delayCurrent, this)
        timer.start()
    }

    fun pauseGame() = timer.stop()


    fun stopGame() {
        timer.stop()
        mapCells = null
        mapDirection = null
        ant = Ant()
        repaint()
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        if (g != null) {
            drawFieldsInCells(g)
            drawDirectionInCells(g)
            drawCells(g)
        }
    }

    private fun drawCells(g: Graphics?) {
        if (g != null) {
            g.color = Color.BLACK
            val rangeX = 0..sizeFieldX step sizeCell
            val rangeY = 0..sizeFieldY step sizeCell

            for (x in rangeX) {
                for (y in rangeY) {
                    g.drawLine(x, y, sizeFieldX, y)
                    g.drawLine(x, y, x, sizeFieldY)
                }
            }
        }
    }

    private fun drawFieldsInCells(g: Graphics?) {
        if (g != null) {
            if (mapCells != null) {
                val points = mapCells!!.keys
                for (point in points) {
                    g.drawImage(mapCells!![point], point.x, point.y, null)
                }
            }
        }
    }

    private fun drawDirectionInCells(g: Graphics?) {
        if (g != null) {
            if (mapDirection != null) {
                val points = mapDirection!!.keys
                for (point in points) {
                    g.drawImage(mapDirection!![point], point.x, point.y, null)
                }
            }
        }
    }

    private fun move() {
        ant.step()
        mapCells = updateMapCells(ant)
        mapDirection = updateAntDirection(ant)
    }

    private fun updateMapCells(ant: Ant): MutableMap<Point, Image>? {
        val fields = ant.fields
        val points = fields.keys
        for (point in points) {
            mapCells?.set(calculatePoints(point), calculateColorCell(fields[point] ?: FieldColor.WHITE))
        }
        return mapCells
    }

    private fun updateAntDirection(ant: Ant): MutableMap<Point, Image>? {
        val antDirection = ant.directionCurrent
        mapDirection?.clear()
        mapDirection?.set(calculatePoints(ant.pointCurrent), calculateDirection(antDirection))
        return mapDirection
    }

    private fun calculateDirection(direction: AntDirection): Image {
        return when (direction) {
            AntDirection.UP -> antUp
            AntDirection.DOWN -> antDown
            AntDirection.RIGHT -> antRight
            AntDirection.LEFT -> antLeft
        }
    }

    private fun calculatePoints(point: Point) = Point(positionStepX + point.x * sizeCell, positionStepY - point.y * sizeCell)

    private fun calculateColorCell(color: FieldColor): Image {
        return when (color) {
            FieldColor.BLACK -> blackCell
            FieldColor.WHITE -> whiteCell
        }
    }

    override fun actionPerformed(e: ActionEvent?) {
        move()
        repaint()
    }
}