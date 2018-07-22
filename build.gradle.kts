import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.jvm.tasks.Jar

group = "com.contenttype.issue"
version = "1.0-SNAPSHOT"

plugins {
    application
    id("org.jetbrains.kotlin.jvm") version "1.2.51"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib", "1.2.51"))
    compile("io.github.microutils:kotlin-logging:1.5.4")
    compile("org.slf4j:slf4j-simple:1.7.25")
    compile("io.javalin:javalin:1.7.0")
}

application {
    mainClassName = "com.contenttype.issue.MainKt"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}