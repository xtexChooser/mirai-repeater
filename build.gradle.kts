plugins {
    val kotlinVersion = "1.5.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
}

group = "com.xtex"
version = "1.8"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("net.mamoe:mirai-core:2.10.0")
    compileOnly("net.mamoe:mirai-core-api:2.10.0")
    compileOnly("net.mamoe:mirai-console:2.10.0")
    implementation("com.google.code.gson:gson:2.8.9")
}

tasks.jar.configure {
    manifest.attributes(mapOf("Implementation-Version" to project.version))
}
