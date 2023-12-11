plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("io.ktor.plugin")
}


dependencies {
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(ktor.client.core)
    implementation(kotlinx.coroutines.core)
    testImplementation(kotlin.test)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}