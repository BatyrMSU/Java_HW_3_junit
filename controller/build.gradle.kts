plugins {
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.google.code.gson:gson:2.8.8")
    implementation(project(":models"))
}

application {
    mainClass.set("mypackage2.Main")
}

tasks.register<JavaExec>("startMainClass") {
    group = "launch"
    mainClass.set("mypackage2.Main")
    standardInput = System.`in`
    classpath = sourceSets["main"].runtimeClasspath
    args("100", "books.txt")
}