tasks.register("terraformValidate") {
    group = "Infrastructure"
    description = "Validate all terraform infrastructure in place within the repo."

    doLast {
        exec {
            workingDir = File(project.projectDir.path)
            commandLine("terraform", "validate")
        }
    }
}
