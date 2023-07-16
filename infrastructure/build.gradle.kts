plugins {
    alias(build.plugins.terraform) //terraform
}

terraform {
    version = "1.5.3"
    useAwsEnvironment() //#TODO environment variables do not trickle through to gradle tasks by default. this works but is deprecated.
}

terraformSourceSets {
    main {
        setSrcDir("./")
    }
}

