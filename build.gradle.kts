val validateEverythingTask = task("ValidateAllProjects")
    .apply {
        group = "Validate Monorepo"
        doFirst {
            val missingValidationTasks = subprojects.filter { it.tasks.withType(MonorepoValidation::class).none() }
            if(missingValidationTasks.isNotEmpty()){
                throw RuntimeException(
                    "Missing validation tasks on some projects: ${missingValidationTasks.joinToString(", ") { it.name }}"
                )
            }
        }
    }

subprojects {
    validateEverythingTask.dependsOn(tasks.withType(MonorepoValidation::class))
}
