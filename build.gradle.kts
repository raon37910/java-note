plugins {
    id("java")
}

group = "com.raon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// 멀티 모듈 프로젝트 전체에 범용적으로 적용할 수 있는 설정
subprojects {
    apply(plugin = "java")

    group = "com.raon"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        // lombok
        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")
        // test
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}