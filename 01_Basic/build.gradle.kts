// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        jcenter()
        
    }
    dependencies {
        classpath(gradleDependencies.gradlePlugin)
        classpath(gradleDependencies.kotlinPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        jcenter()
        
    }
}

 tasks.register("clean", Delete::class) {
        delete(rootProject.buildDir)
     }
