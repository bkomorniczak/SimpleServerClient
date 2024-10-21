plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

tasks.jar {
    archiveBaseName.set("tcp-server") // Set custom base name for the JAR
    archiveVersion.set("") // Removes the version from the JAR file name
    archiveClassifier.set("") // Removes any classifier like 'plain'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation ("io.micrometer:micrometer-registry-prometheus")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
