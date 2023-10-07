terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }

  backend "s3" {
    bucket = "alloba-terraform-state-files"
    key = "alloba-mono"
    region = "us-east-1"
  }
}

provider "aws" {
  default_tags {
    tags = {
      project = "alloba-mono"
      managedBy = "Terraform"
      environment = terraform.workspace
    }
  }
}
