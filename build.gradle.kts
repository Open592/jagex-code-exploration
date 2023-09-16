plugins {
    id("java")
    id("application")
}

group = "com.open592"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.open592.jagexappletviewer.jagexappletviewer")

    applicationDefaultJvmArgs = listOf(
        "--add-opens=java.base/sun.security.pkcs=ALL-UNNAMED",
        "-Dsun.java2d.noddraw=true",
        "-Djava.net.preferIPv4Stack=true",
        "-Dcom.jagex.config=http://localhost:8000/jav_config.ws",
        "-Dcom.jagex.debug=true",
        "-Dcom.jagex.hostConsole=false",
    )
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.open592.jagexappletviewer.jagexappletviewer"
    }
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs

    compilerArgs.add("--add-exports=java.base/sun.security.pkcs=ALL-UNNAMED")
}

tasks.test {
    useJUnitPlatform()
}
