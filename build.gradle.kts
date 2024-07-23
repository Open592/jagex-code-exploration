plugins {
    id("java")
    id("application")
}

group = "com.jagex"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.jagex.cmd.jagexappletviewer")

    applicationDefaultJvmArgs = listOf(
        "--add-opens=java.base/sun.security.pkcs=ALL-UNNAMED",
        "-Dsun.java2d.noddraw=true",
        "-Djava.net.preferIPv4Stack=true",
        "-Dcom.jagex.config=http://localhost:8000/jav_config.ws",
        "-Dcom.jagex.debug=true",
        "-Dcom.jagex.hostConsole=false",
    )
}

java {
    toolchain {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
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
        attributes["Main-Class"] = "com.jagex.cmd.jagexappletviewer"
    }
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs

    compilerArgs.add("--add-exports=java.base/sun.security.pkcs=ALL-UNNAMED")

    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}
