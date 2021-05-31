package main

import java.awt.BorderLayout
import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JPanel

class KotlinSwingSimple(title: String) : JFrame() {
    init {
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(1280, 800)
        setLocationRelativeTo(null)
    }
}

fun main() {
    EventQueue.invokeLater(::createGui)
}

fun createGui() {
    val frame = KotlinSwingSimple("Langton's Ant")
    frame.isVisible = true
    val panel = JPanel()
    panel.layout = BorderLayout()
    val fieldGui = FieldGui()

    panel.add(ControlPanelGui(fieldGui), BorderLayout.NORTH)
    panel.add(fieldGui, BorderLayout.CENTER)
    frame.add(panel)
}
