import com.github.gradle.node.npm.task.NpmInstallTask
import com.github.gradle.node.npm.task.NpxTask

plugins {
  id ("com.github.node-gradle.node") version "5.0.0"
}

node {
  download = true
  version = "16.14.0"
  npmInstallCommand = "ci"
}

val installProject by tasks.register<NpmInstallTask>("installKaleidoscope")

val buildProject by tasks.register<NpxTask>("buildKaleidoscope"){
  command = "ng"
  args = listOf("build", "--prod")
  dependsOn(installProject)
}

//tasks.register<MonorepoValidation>("ValidateKaleidoscope") {
//  supportingTask = buildProject
//}
