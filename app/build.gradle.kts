plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.whatsappclone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.whatsappclone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Core AndroidX Libraries
    implementation(libs.appcompat)
    implementation(libs.material)

    // Firebase BoM (correct Kotlin DSL syntax!)
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))

    // Firebase Authentication (email/password & phone)
    implementation("com.google.firebase:firebase-auth")
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // OPTIONAL: Google Sign-In
    // implementation("com.google.android.gms:play-services-auth:20.7.0")
}
