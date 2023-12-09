plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.android)
    alias(libs.plugins.dagger.hilt)
    kotlin("kapt")
}

android {
    namespace ="app.validator"
    compileSdk =  33

    defaultConfig {
        applicationId= "app.validator"
        minSdk= 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    testOptions.unitTests.isIncludeAndroidResources = true


    buildFeatures {
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.compat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.fragment)

    implementation(libs.androidx.activity.ktx)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.dynamic)


    implementation(libs.com.dagger)
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    kapt(libs.com.dagger.compiler)

    testImplementation("io.mockk:mockk:1.13.8")
    debugImplementation("androidx.fragment:fragment-testing:1.3.6")
    kaptTest("com.google.dagger:hilt-android-compiler:2.44")
    testImplementation("com.google.dagger:hilt-android-testing:2.44")
    testImplementation("org.robolectric:robolectric:4.11.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

