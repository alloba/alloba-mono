val validateTask by tasks.register("terraformValidate") {
    group = "Infrastructure"
    description = "Validate all terraform infrastructure in place within the repo."

    doLast {
        exec {
            workingDir = File(project.projectDir.path)
            commandLine("terraform", "validate")
        }
    }
}

tasks.register("terraformApply"){
    group = "Infrastructure"
    description = "Deploy terraform project."

    doLast {
        exec {
            workingDir = File(project.projectDir.path)
            commandLine("terraform", "apply", "--auto-approve")
        }
    }
}

tasks.register<MonorepoValidation>("ValidateInfrastructure") {
    supportingTask = validateTask
}
