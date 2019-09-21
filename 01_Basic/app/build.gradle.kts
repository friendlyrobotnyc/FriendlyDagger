plugins {

    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}




android {
    compileSdkVersion (Versions.compileSdk)
    buildToolsVersion ( Versions.buildTools)
    defaultConfig {
        applicationId  = "friendlyrobot.nyc.friendlydagger.basic"
        minSdkVersion  (Versions.minSdk)
        targetSdkVersion  (Versions.targetSdk)
        versionCode =  1
        versionName  = "1.0"
        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation (androidDependencies.kotlin)
    implementation (androidDependencies.appCompat)
    implementation (androidDependencies.ktxCore)
    implementation (androidDependencies.recyclerView)

    implementation (libraryDependencies.moshi)
    implementation (libraryDependencies.retrofit)
    implementation (libraryDependencies.moshiRetrofit)
    implementation (libraryDependencies.dagger)

    kapt (annotationDependencies.dagger)
    kapt (libraryDependencies.moshiCodegen)

    testImplementation (testDependencies.junit)
    testImplementation (testDependencies.mockk)

    androidTestImplementation (testDependencies.junitKtx)
}
