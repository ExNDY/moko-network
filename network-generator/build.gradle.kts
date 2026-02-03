/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.gradle.plugin-publish") version ("1.3.1")
    id("java-gradle-plugin")
}

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.kotlinGradlePlugin)
        classpath(libs.mokoGradlePlugin)
        classpath(libs.kotlinSerializationGradlePlugin)
    }
}

apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "dev.icerock.moko.gradle.detekt")
apply(plugin = "dev.icerock.moko.gradle.publication")
apply(plugin = "dev.icerock.moko.gradle.publication.nexus")

group = "dev.icerock.moko"
version = libs.versions.mokoNetworkVersion.get()

dependencies {
    implementation(gradleKotlinDsl())
    compileOnly(libs.kotlinGradlePlugin)
    implementation(libs.guava)
    implementation(libs.openApiGenerator)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

gradlePlugin {
    website.set("https://github.com/icerockdev/moko-network")
    vcsUrl.set("https://github.com/icerockdev/moko-network")

    plugins {
        create("multiplatform-network-generator") {
            id = "dev.icerock.mobile.multiplatform-network-generator"
            displayName = "MOKO network generator plugin"
            implementationClass = "dev.icerock.moko.network.MultiPlatformNetworkGeneratorPlugin"
            description = "Plugin to provide network components for iOS & Android"
            tags = listOf("moko-network", "moko", "kotlin", "kotlin-multiplatform")
        }
    }
}
