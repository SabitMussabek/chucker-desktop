plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.compose)
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
