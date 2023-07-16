//TODO: adding terraform to gradle was such a massive pain... is it really worth it? maybe just use terraform separately...

plugins {
    alias(build.plugins.terraform) //terraform
}

terraform {
    version = "1.5.3"
    useAwsEnvironment() //#TODO environment variables do not trickle through to gradle tasks by default. this works but is deprecated.
}

terraformSourceSets {
    main {
        setSrcDir("./") //override default src/tf directory.
    }
}

