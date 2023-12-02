plugins {
    kotlin("jvm") version "1.9.21"
    id("io.ktor.plugin") version "2.3.6"
}

group = "com.chuckerdesktop"
version = "1.0.0"

dependencies {
    implementation("io.ktor:ktor-client-core")
    implementation("org.jetbrains.compose.ui:ui-desktop:1.5.11")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}