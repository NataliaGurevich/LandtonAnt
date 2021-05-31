package main

enum class FieldColor {
    WHITE,
    BLACK;

    fun changeColor(): FieldColor = if (this == BLACK) WHITE else BLACK
}