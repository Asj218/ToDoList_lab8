plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.bignerdranch.android.todolist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bignerdranch.android.todolist"
        minSdk = 24
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("androidx.room:room-runtime:2.4.2")

    //kapt("androidx.room:room-compiler:2.4.2")
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")

    //implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    //implementation("androidx.appcompat:appcompat:1.4.1")
    //implementation("androidx.core:core-ktx:1.7.0")
    //implementation("com.google.android.material:material:1.5.0")
    //implementation("androidx.recyclerview:recyclerview:1.2.1")


    //implementation("androidx.work:work-runtime-ktx:2.7.0")
    //implementation("com.google.code.gson:gson:2.8.5")
    //implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //implementation("com.squareup.retrofit2:converter-scalars:2.5.0")
    //implementation("androidx.recyclerview:recyclerview:1.3.2")

    testImplementation(libs.junit)
    //kapt(libs.room.compiler)
    //testImplementation("junit:junit:4.13.2")//
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")//
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")//
}