plugins {
    id("java")
}

group = "com.raon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // reactor
    implementation("io.projectreactor:reactor-core:3.7.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}