plugins {
    kotlin("jvm") version "1.9.21" apply false
    id("org.jetbrains.compose") version "1.5.11" apply false
    id("io.ktor.plugin") version "2.3.0" apply false
}

allprojects {

    group = "com.chuckerdesktop"
    version = "1.0.0"

    repositories {
        google()
        mavenCentral()
    }
}