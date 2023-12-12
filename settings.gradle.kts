plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include("library")
include("sample")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            version("ktor", "2.3.7")
            version("kotlinx", "1.7.1")
            version("compose", "1.5.11")
            version("kotlin", "1.9.21")

            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("compose", "org.jetbrains.compose").versionRef("compose")
            plugin("ktor", "io.ktor.plugin").versionRef("ktor")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinx")
            library("ktor-client-core", "io.ktor", "ktor").versionRef("ktor")

        }
    }
}
