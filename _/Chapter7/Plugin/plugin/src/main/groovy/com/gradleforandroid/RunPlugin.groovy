package com.gradleforandroid

import org.gradle.api.Project
import org.gradle.api.Plugin

class RunPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.android.applicationVariants.all { variant ->
            if (variant.install) {
                project.tasks.create(name: "run${variant.name.capitalize()}", dependsOn: variant.install) {
                    description "Installs the ${variant.description} and runs the main launcher activity."

                    doFirst {
                        def classpath = variant.applicationId
                        if (variant.buildType.applicationIdSuffix) {
                            classpath -= "${variant.buildType.applicationIdSuffix}"
                        }
                        def launchClass = "${variant.applicationId}/${classpath}.MainActivity"
                        project.exec {
                            executable = 'adb'
                            args = ['shell', 'am', 'start', '-n', launchClass]
                        }
                    }
                }
            }
        }
    }
}