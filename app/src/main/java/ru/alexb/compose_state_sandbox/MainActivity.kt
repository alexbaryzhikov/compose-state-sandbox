package ru.alexb.compose_state_sandbox

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = CounterButton(findViewById(R.id.button), Counter())
        button.initialize()
    }
}

class Counter {
    var value: Int = 0

    fun increment() {
        value++
    }
}

class CounterButton(private val button: Button, private val counter: Counter) {
    fun initialize() {
        button.text = "Counter: ${counter.value}"
        button.setOnClickListener {
            counter.increment()
        }
    }
}
