rootProject.name = "gradle-junit5"

pluginManagement {
    repositories {
        mavenCentral()

        // Uncomment and configure these as needed:
        // mavenLocal()
        // gradlePluginPortal()
        // maven {
        //     name = "localPluginRepository"
        //     url = uri("/Users/rahul.m/Documents/SDKRepos/browserstack-javaagent/BrowserstackGradlePlugin/local-plugin-repository")
        // }
        // maven {
        //     name = "MavenCentralStaging"
        //     url = uri("https://oss.sonatype.org/content/repositories/combrowserstack-1245")
        // }
        // flatDir {
        //     dirs("/Users/kamalpreet/.m2/repository/com/browserstack/gradle-sdk/com.browserstack.gradle-sdk.gradle.plugin/116.0.0")
        // }
        // flatDir {
        //     // dirs("/Users/kamalpreet/Documents/browserstack/browserstack-javaagent/BrowserstackGradlePlugin/build/libs")
        //     dirs("/Users/kamalpreet/.m2/repository/")
        // }
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.browserstack.gradle-sdk") {
                useModule("com.browserstack:gradle-sdk:1.1.2")
                // Uncomment and adjust version as needed:
                // useModule("com.browserstack:gradle-sdk:1.0.0")
            }
        }
    }
}
