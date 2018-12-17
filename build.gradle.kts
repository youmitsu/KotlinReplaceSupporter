import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import org.gradle.jvm.tasks.Jar

buildscript {
    val kotlinVersion = "1.2.10"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

group = "jp.co.youmeee"
version = "1.2"
plugins {
    java
    application
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "1.1.51"
    id("com.github.johnrengelman.shadow") version "2.0.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    val kotlinVersion = "1.2.10"
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    testCompile(group = "junit", name = "junit", version = "4.12")
    compile ("org.slf4j:slf4j-api:1.7.25")
    compile("org.slf4j:jcl-over-slf4j:1.7.25")
    compile("org.slf4j:jul-to-slf4j:1.7.25")
    compile("ch.qos.logback:logback-classic:1.2.3")
}

task("packJar", type = Jar::class) {
    manifest {
        attributes["Main-Class"] = "jp.co.youmeee.app.MainKt"
    }
    from(configurations.runtime.map({ if (it.isDirectory) it else zipTree(it) }))
    with(tasks["jar"] as CopySpec)
}