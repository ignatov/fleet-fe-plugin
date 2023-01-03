project.version = "1.0.1"

plugins {
    kotlin("jvm") version "1.7.22"
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

fleet {
    fleetPath.set("/Users/ignatov/Fleet/32261aa6f5d60-debug/Fleet.app/")
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}