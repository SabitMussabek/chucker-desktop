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