plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("io.ktor.plugin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(compose.desktop.currentOs)
    implementation(libs.ktor.client.core)
    implementation(libs.kotlinx.coroutines.core)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
