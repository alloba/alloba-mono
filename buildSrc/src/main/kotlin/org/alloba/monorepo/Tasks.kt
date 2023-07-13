//package org.alloba.monorepo

import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

abstract class MonorepoValidation() : DefaultTask() {

    override fun getGroup(): String {
        return "Validate Monorepo"
    }

    //TODO: This is miserable, but it's the only way i could get things working with how much i know about gradle currently.
    @get:Input
    var supportingTask:Task? = null
        set(value) {
            field = value
            this.dependsOn(supportingTask)
        }


    @TaskAction
    fun validate(){
        println("Validating system - ${this.project.name}:${this.name}")
    }
}
