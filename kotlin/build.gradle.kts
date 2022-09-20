plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    //id("org.jetbrains.kotlin.plugin.jpa")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("com.google.cloud.tools.jib") version "3.3.0"
    id("io.micronaut.application") version "3.5.3"
}

val kotlinVersion = project.properties["kotlinVersion"]

version = "0.1"
group = "example.micronaut"



repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut.discovery:micronaut-discovery-client")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    compileOnly("org.graalvm.nativeimage:svm")

    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("example.micronaut.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
}

allOpen {
    annotations("javax.transaction.Transactional", "io.micronaut.http.annotation.Controller")
}

jib {
    from {
        image = "gcr.io/distroless/java17-debian11:latest@sha256:d5024ba6d66e3e56f8746b48aad7e8f58a81092044b64efa292defa1550cd497"
    }
    container {
        creationTime = "USE_CURRENT_TIMESTAMP"
        // ports = ['8080']
        // extraDirectories {
        //    paths = 'src/main/container'  // Copies files from 'bin'
        //     permissions = [
        //        '/path/on/container/to/fileA': '755',
        //    ]
        // }
        environment = mapOf(
            "MICRONAUT_ENV_DEDUCTION" to "false",
            "VAULT_TOKEN" to "secret",
            "VAULT_ADDR" to "http://vault:8200",
        )
        user = "10001:10001"
    }
}