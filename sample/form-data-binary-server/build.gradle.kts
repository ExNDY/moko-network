plugins {
    id("kotlin")
    id("application")
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.ktorServerNetty)
    implementation(libs.ktorServerCore)
    implementation(libs.logback)
}
