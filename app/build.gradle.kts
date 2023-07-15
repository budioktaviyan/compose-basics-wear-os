plugins {
  id("com.android.application")
  kotlin("android")
}

@Suppress("UnstableApiUsage")
android {
  namespace = "id.android.basics.compose"
  compileSdk = 33
  buildToolsVersion = "34.0.0"

  defaultConfig {
    applicationId = "id.android.basics.compose"
    minSdk = 30
    targetSdk = 33
    versionCode = 1
    versionName = "1.0.0"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs.plus("-Xopt-in=kotlin.RequiresOptIn")
  }
  buildFeatures.compose = true
  composeOptions.kotlinCompilerExtensionVersion = "1.4.8"
  packaging {
    resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
  }
}

dependencies {
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation("androidx.compose.foundation:foundation:1.4.3")
  implementation("androidx.compose.material:material-icons-extended:1.4.3")
  implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
  implementation("androidx.wear.compose:compose-material:1.1.2")
  implementation("androidx.wear.compose:compose-foundation:1.1.2")

  testImplementation("junit:junit:4.13.2")

  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")

  debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
}