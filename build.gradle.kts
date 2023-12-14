plugins {
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.ktor).apply(false)
    alias(libs.plugins.compose).apply(false)
}

allprojects {
    group = "com.chuckerdesktop"
    version = "1.0.0"

    repositories {
        google()
        mavenCentral()
    }
}
