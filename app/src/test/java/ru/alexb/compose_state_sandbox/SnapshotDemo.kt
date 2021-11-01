package ru.alexb.compose_state_sandbox

import androidx.compose.runtime.mutableStateOf

fun main() {
    val name = mutableStateOf("")
    name.value = "Alice"
    println(name.value)
}
