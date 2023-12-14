plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":library"))
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(compose.desktop.currentOs)
    implementation(libs.bundles.ktor)
    implementation(libs.kotlinx.coroutines.core)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
