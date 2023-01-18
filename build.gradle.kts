project.version = "1.0.1"

plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

fleet {
    fleetPath.set("/Users/ignatov/Fleet/4debb904fe532-debug/Fleet.app/")
//    fleetPath.set("/Users/ignatov/Fleet/50f36861f6389-debug/Fleet.app/")
//    fleetPath.set("/Users/ignatov/Fleet/32261aa6f5d60-debug/Fleet.app/")
//    fleetPath.set("/Users/ignatov/Fleet/87120b1bf721e-debug/Fleet.app")
//    fleetVersion.set("1.14.53")

    frontend {
        add("org.twitter4j:twitter4j-core:4.1.1") {
            exclude(group = "org.jetbrains", module = "annotations")
        }
//        add("io.ktor:ktor-client-cio:2.2.2")
//        add("com.aallam.openai:openai-client:2.1.2") {
//            exclude(group = "io.ktor")
//            exclude(group = "org.jetbrains.kotlin")
//            exclude(group = "com.squareup.okio")
//            exclude(group = "io.ktor.websocket.serialization")
//            exclude(group = "io.ktor.serialization")
//            exclude(group = "io.ktor.network.tls")
//            exclude(group = "org.jetbrains.kotlinx")
//            exclude(group = "org.slf4j")
//            exclude(group = "org.jetbrains", module = "annotations")
//        }
    }
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}