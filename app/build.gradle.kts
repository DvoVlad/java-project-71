plugins {
    application
    id("com.diffplug.spotless") version "6.25.0"
    id("io.github.ben-manes.versions") version "0.66.0"
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

spotless {
    java {
        importOrder()
        removeUnusedImports()
        googleJavaFormat().aosp()
        formatAnnotations()
        indentWithSpaces(4)
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.23.0")
}

tasks.test {
    useJUnitPlatform()
}