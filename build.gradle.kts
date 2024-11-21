plugins {
    id("java")
    id("com.browserstack.gradle-sdk") version "1.1.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("io.appium:java-client:9.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.18.1")
//    implementation("org.junit.jupiter:junit-jupiter-api:")
//    implementation("org.junit.jupiter:junit-jupiter-engine:${property("junit.jupiter.version")}")
    // Uncomment the below line if needed
     testImplementation("com.browserstack:browserstack-java-sdk:1.27.0")
//    implementation(files("/Users/rahul.m/Documents/SDKRepos/browserstack-javaagent/target/browserstack-java-sdk-1.2600.4000.jar"))

}

//val kk by tasks.registering(JavaExec::class) {
////    group = "Execution"
////    description = "Run schema printer task"
////    val javaPluginConvention = project.convention.getPlugin(JavaPluginConvention::class.java)
////    classpath = javaPluginConvention.sourceSets.getByName("test").runtimeClasspath
////    javaPluginConvention.sourceSets.getByName("main").runtimeClasspath.forEach { println(it) }
////    mainClass.set("com.browserstack.Sample")
////    jvmArgs = listOf("-javaagent:/Users/rahul.m/Documents/SDKRepos/browserstack-javaagent/target/browserstack-java-sdk-1.2600.4000.jar")
//    // Uncomment and modify the below lines as needed
//    // doFirst {
//    //     configurations.testRuntimeClasspath
//    //         ?.find { it.name.startsWith("browserstack-java-sdk") }
//    //         ?.let { jvmArgs("-javaagent:/path/to/sdk.jar") }
//    // }
//}

tasks.withType<Test>().configureEach {
    doFirst {
        configurations.testRuntimeClasspath.get()
            .find { it.name.startsWith("browserstack-java-sdk") }
            ?.let { jvmArgs("-javaagent:$it") }
    }
}



tasks.test {
    useJUnitPlatform()
}