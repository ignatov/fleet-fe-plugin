project.version = "1.0.1"

plugins {
    kotlin("jvm") version "1.7.22"
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

fleet {
//    fleetPath.set("/Users/ignatov/Fleet/32261aa6f5d60-debug/Fleet.app/")

//    fleetPath.set("/Users/ignatov/Fleet/87120b1bf721e-debug/Fleet.app")
    fleetVersion.set("1.14.53")

    frontend {
        add("org.twitter4j:twitter4j-core:4.1.1")
        add("com.aallam.openai:openai-client:2.1.2")
    }
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}