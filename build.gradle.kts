//val validateEverythingTask = task("ValidateAllProjects").apply {
//        group = "Validate Monorepo"
//        doFirst {
//            val missingValidationTasks = subprojects.filter { it.tasks.withType(MonorepoValidation::class).none() }
//            if (missingValidationTasks.isNotEmpty()) {
//                throw RuntimeException(
//                    "Missing validation tasks on some projects: ${missingValidationTasks.joinToString(", ") { it.name }}"
//                )
//            }
//        }
//    }
//
//subprojects {
//    validateEverythingTask.dependsOn(tasks.withType(MonorepoValidation::class))
//}

plugins {
    // the plugin being used for tf has to be in the top level build. not settings, and not only in a child repo.
    // it's weird but im rolling with it for now.
    alias(build.plugins.terraform)
}
