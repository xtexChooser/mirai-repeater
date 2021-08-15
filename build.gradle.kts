plugins {
    val kotlinVersion = "1.5.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.xtex"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    compileOnly("net.mamoe:mirai-core-api:2.7-RC")
    compileOnly("net.mamoe:mirai-console:2.7-RC")
    implementation("com.google.code.gson:gson:2.8.7")
}

tasks.jar.configure {
    manifest.attributes(mapOf("Implementation-Version" to project.version))
}

tasks.shadowJar.configure {
    configurations = mutableListOf(project.configurations.runtimeClasspath.get())
}
