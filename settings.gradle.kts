pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}

rootProject.name = "MultiplatformLib"
include(":shared")