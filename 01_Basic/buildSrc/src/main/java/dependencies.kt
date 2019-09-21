object Versions {

    val compileSdk = 29
    val targetSdk = 29
    val minSdk = 21
    val buildTools = "29.0.2"
    val gradlePlugin = "3.6.0-alpha12"
    val kotlin = "1.3.50"
    val ktxCore = "1.1.0"

    //android
    val appCompat = "1.1.0"
    val constraintLayout = "1.1.3"
    val recyclerView = "1.0.0"

    //lib
    val dagger = "2.24"
    val moshi = "1.9.0-SNAPSHOT"
    val retrofit = "2.6.1"
    val timber = "4.7.1"

    //test
    val mockk = "1.9"
    val junit = "4.12"
    val junitKtx = "1.1.1"
}

object gradleDependencies {
    val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object testDependencies {
    val junit = "junit:junit:${Versions.junit}"
    val junitKtx = "androidx.test.ext:junit:${Versions.junitKtx}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
}

object androidDependencies {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
}

object libraryDependencies {
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    val moshiRetrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object annotationDependencies {
    val dagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}
