package ru.alexb.compose_state_sandbox

import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
    val name = mutableStateOf("", policy = object : SnapshotMutationPolicy<String> {
        override fun equivalent(a: String, b: String): Boolean = a == b
        override fun merge(previous: String, current: String, applied: String): String =
            "$applied aka $current"
    })
    name.value = "Alice"
    println("initial value: " + name.value)
    val snapshot1 = Snapshot.takeMutableSnapshot()
    val snapshot2 = Snapshot.takeMutableSnapshot()
    snapshot1.enter { name.value = "Bob" }
    snapshot2.enter { name.value = "Cain" }
    snapshot1.apply().check()
    println("snapshot1 applied: " + name.value)
    snapshot2.apply().check()
    println("snapshot2 applied: " + name.value)
}
