/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dev.icerock.moko.gradle.multiplatform.mobile")
    id("dev.icerock.mobile.multiplatform-resources")
    id("dev.icerock.moko.gradle.detekt")
    id("dev.icerock.moko.gradle.publication")
    id("dev.icerock.moko.gradle.stub.javadoc")
}

android {
    namespace = "dev.icerock.moko.network.errors"
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    commonMainImplementation(libs.kotlinSerialization)

    commonMainApi(libs.mokoErrors)
    commonMainApi(libs.mokoResources)

    commonMainImplementation(project(":network"))
}

multiplatformResources {
    resourcesPackage = "dev.icerock.moko.network.errors"
}
