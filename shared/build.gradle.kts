plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
        //id("convention.publication")
}

//group = "com.multiplatform.lib.base64"
//version = "1.0.0"



@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()
    //targetHierarchy.default()

    androidTarget{
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.trackensure.multiplatformlib"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    testFixtures {
        enable = true
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))        // << --- ADD This
    }
}
//===============================

java {
    sourceCompatibility = JavaVersion.VERSION_17            // << --- ADD This
    targetCompatibility = JavaVersion.VERSION_17
}

publishing {
    publications {
        register<MavenPublication>("release",) {
            groupId = "com.github.dzertak"
            artifactId = "com.trackensure.multiplatformlib"
            version = "1.0.2"
            pom {
                description.set("First release")
            }
//            afterEvaluate {
//                //artifact(tasks.getByName("bundleRelease"))
//                //from(components["release"])
//            }
        }
        repositories {
            maven {
                name = "myrepoBase64"
                url = uri("${project.buildDir}/repo")
            }
        }
    }
}