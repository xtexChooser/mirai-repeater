plugins {
    val kotlinVersion = "1.5.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
}

group = "com.xtex"
version = "1.6"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    compileOnly("net.mamoe:mirai-core:2.8.0-RC")
    compileOnly("net.mamoe:mirai-core-api:2.8-M1")
    compileOnly("net.mamoe:mirai-console:2.8-M1")
    implementation("com.google.code.gson:gson:2.8.9")
}

tasks.jar.configure {
    manifest.attributes(mapOf("Implementation-Version" to project.version))
}
