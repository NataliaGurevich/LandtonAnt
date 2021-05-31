package main

import java.awt.Button
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JPanel

class ControlPanelGui(fieldPanel: FieldGui) : JPanel() {

    private val startButton = Button("START")
    private val pauseButton = Button("PAUSE")
    private val stopButton = Button("STOP")
    private val speedPlusButton = Button("SPEED + ")
    private val speedMinusButton = Button("SPEED - ")

    init {
        this.layout = FlowLayout()
        startButton.addActionListener(StartActionListener(fieldPanel, startButton, pauseButton, stopButton, speedPlusButton, speedMinusButton))
        this.add(startButton)

        pauseButton.addActionListener(PauseActionListener(fieldPanel, startButton, pauseButton, stopButton, speedPlusButton, speedMinusButton))
        this.add(pauseButton)
        pauseButton.isEnabled = false

        stopButton.addActionListener(StopActionListener(fieldPanel, startButton, pauseButton, stopButton, speedPlusButton, speedMinusButton))
        this.add(stopButton)
        stopButton.isEnabled = false

        speedPlusButton.addActionListener(SpeedPlusActionListener(fieldPanel, startButton, pauseButton, stopButton, speedPlusButton, speedMinusButton))
        this.add(speedPlusButton)
        speedPlusButton.isEnabled = false

        speedMinusButton.addActionListener(SpeedMinusActionListener(fieldPanel, startButton, pauseButton, stopButton, speedPlusButton, speedMinusButton))
        this.add(speedMinusButton)
        speedMinusButton.isEnabled = false
    }

    class StartActionListener(private val fieldPanel: FieldGui, private val startButton: Button, private val pauseButton: Button, private val stopButton: Button, private val speedPlusButton: Button, private val speedMinusButton: Button) : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            fieldPanel.startGame()

            startButton.isEnabled = false
            pauseButton.isEnabled = true
            stopButton.isEnabled = true
            CheckUtils(fieldPanel, speedPlusButton, speedMinusButton).checkDelay()
        }
    }

    class PauseActionListener(private val fieldPanel: FieldGui, private val startButton: Button, private val pauseButton: Button, private val stopButton: Button, private val speedPlusButton: Button, private val speedMinusButton: Button) : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            fieldPanel.pauseGame()

            startButton.isEnabled = true
            pauseButton.isEnabled = false
            stopButton.isEnabled = true
            speedPlusButton.isEnabled = false
            speedMinusButton.isEnabled = false
        }
    }

    class StopActionListener(private val fieldPanel: FieldGui, private val startButton: Button, private val pauseButton: Button, private val stopButton: Button, private val speedPlusButton: Button, private val speedMinusButton: Button) : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            fieldPanel.stopGame()

            startButton.isEnabled = true
            pauseButton.isEnabled = false
            stopButton.isEnabled = false
            speedPlusButton.isEnabled = false
            speedMinusButton.isEnabled = false
        }
    }

    class SpeedPlusActionListener(private val fieldPanel: FieldGui, private val startButton: Button, private val pauseButton: Button, private val stopButton: Button, private val speedPlusButton: Button, private val speedMinusButton: Button) : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            var delayCurrent = fieldPanel.delayCurrent
            val delay = 25
            val delayCurrentMin = 0

            if ((delayCurrent - delay) >= delayCurrentMin) {
                delayCurrent -= delay
                fieldPanel.delayCurrent = delayCurrent
            }
            startButton.isEnabled = false
            pauseButton.isEnabled = true
            stopButton.isEnabled = true
            CheckUtils(fieldPanel, speedPlusButton, speedMinusButton).checkDelay()
        }
    }

    class SpeedMinusActionListener(private val fieldPanel: FieldGui, private val startButton: Button, private val pauseButton: Button, private val stopButton: Button, private val speedPlusButton: Button, private val speedMinusButton: Button) : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            var delayCurrent = fieldPanel.delayCurrent
            val delay = 25
            val delayCurrentMax = 1000

            if ((delayCurrent + delay) <= delayCurrentMax) {
                delayCurrent += delay
                fieldPanel.delayCurrent = delayCurrent
            }
            startButton.isEnabled = false
            pauseButton.isEnabled = true
            stopButton.isEnabled = true
            CheckUtils(fieldPanel, speedPlusButton, speedMinusButton).checkDelay()
        }
    }
}

class CheckUtils(private var fieldPanel: FieldGui, private val speedPlusButton: Button, private val speedMinusButton: Button) {
    fun checkDelay() {
        val delayCurrent = fieldPanel.delayCurrent
        val delay = 25
        val delayCurrentMin = 0
        val delayCurrentMax = 1000

        speedPlusButton.isEnabled = (delayCurrent - delay) >= delayCurrentMin
        speedMinusButton.isEnabled = (delayCurrent + delay) <= delayCurrentMax
    }
}