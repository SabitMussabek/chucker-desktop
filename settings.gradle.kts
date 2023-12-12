plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include("library")
include("sample")

dependencyResolutionManagement {
    versionCatalogs {
//        create("libs") {
//            from(files("gradle/libs.versions.toml"))
//        }
    }
}
