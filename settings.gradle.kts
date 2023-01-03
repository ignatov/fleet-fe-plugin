rootProject.name = "fleet-fe-plugin"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://cache-redirector.jetbrains.com/intellij-dependencies") // WTF??
    }
}

includeBuild("/Users/ignatov/src/intellij/fleet/gradle-plugin")