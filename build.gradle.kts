plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.mockito:mockito-core:2.24.0")
        testImplementation("junit:junit:4.12")
        testImplementation("org.hamcrest:hamcrest-all:1.3")

        implementation("com.google.inject:guice:5.0.1")
        implementation("org.jetbrains:annotations:13.0")
        compileOnly("org.projectlombok:lombok:1.18.22")
        annotationProcessor("org.projectlombok:lombok:1.18.22")
    }
}