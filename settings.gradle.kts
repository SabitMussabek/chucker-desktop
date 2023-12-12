plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include("library")
include("sample")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            version("kotlinx", "1.7.2")
            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinx")

            version("ktor", "2.3.7")
            library("ktor-client-core", "io.ktor", "ktor").versionRef("ktor")


        }
    }
}
