plugins {
    alias(build.plugins.terraform) //terraform
}

terraform {
    version = "1.5.3"
    useAwsEnvironment()
}

terraformSourceSets {
    main {
        setSrcDir("./")
    }
}

