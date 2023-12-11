@file:Suppress("ConstPropertyName", "UnusedReceiverParameter")

import org.gradle.api.artifacts.dsl.DependencyHandler


val DependencyHandler.ktor: Ktor get() = Ktor
val DependencyHandler.kotlinx: Kotlinx get() = Kotlinx
val DependencyHandler.kotlin: Kotlin get() = Kotlin

object Kotlinx {
    val coroutines: Coroutines get() = Coroutines
    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3"
    }
}

object Ktor {
    val client: Client get() = Client
    object Client {
        const val core = "io.ktor:ktor-client-core"
    }
}
object Kotlin {
    const val test = "org.jetbrains.kotlin:kotlin-test"
}
