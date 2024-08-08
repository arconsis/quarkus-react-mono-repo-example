group = "org.acme"
version = "1.0.0-SNAPSHOT"

plugins {
    kotlin("jvm") apply false
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}

tasks.register("lintAll") {
    description = "Runs linting on client"
    dependsOn(subprojects.mapNotNull { it.tasks.findByName("lint") })
}