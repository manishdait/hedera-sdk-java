// SPDX-License-Identifier: Apache-2.0
plugins { id("org.hiero.gradle.build") version "0.3.0" }

rootProject.name = "hiero-sdk-java"

javaModules {
    module("sdk") { group = "org.hiero" }
    module("sdk-full") { group = "org.hiero" }
    module("tck") { group = "org.hiero.sdk.tck" }
}

includeBuild("examples")

includeBuild("example-android")
