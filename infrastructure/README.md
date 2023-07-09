# Alloba Mono Infrastructure

This is where all the core infrastructure for my projects is stored. 
Every effort should be made to keep any infrastructure within this directory, 
and not in bespoke one-off locations. 

## Terraform State Files

Terraform state is all centralized in a single S3 bucket - `alloba-terraform-state-files`. 
This bucket is manually configured and managed, and should be the only thing that needs to be kept outside terraform.

## Tagging Conventions

All infrastructure should use a set of consistent tags for all resources. 
This is most easily done through default tags in the `aws` terraform provider: 

```hcl
provider "aws" {
  default_tags {
    tags = {
      project = "personal-landing-site"
      managedBy = "Terraform"
      environment = "default"
    }
  }
}
```