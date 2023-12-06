plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.compose") version "1.5.11"
    id("io.ktor.plugin") version "2.3.6"
}

group = "com.chuckerdesktop"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(compose.desktop.currentOs)
    implementation("io.ktor:ktor-client-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}