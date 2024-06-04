import org.jetbrains.kotlin.config.JvmAnalysisFlags.useIR

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.chargingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chargingapp"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    useLibrary("android.car")
}

dependencies {

    //Core
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")

    //Automotive OS
    implementation("androidx.car.app:app-automotive:1.4.0")

    //Compose
    val compose_bom = rootProject.extra["compose_bom"]
    implementation (platform("androidx.compose:compose-bom:$compose_bom"))
    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.activity:activity-compose:1.9.0")

    implementation("androidx.compose.material3:material3-android:1.2.1")

}